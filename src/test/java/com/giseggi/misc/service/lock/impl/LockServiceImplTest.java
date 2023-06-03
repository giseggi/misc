package com.giseggi.misc.service.lock.impl;

import com.giseggi.misc.service.lock.LockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LockServiceImplTest {

    @Autowired
    private LockService testClass;

    private static final int RESOURCE_CAPACITY = 10;

    @Test
    public void testLockAndUnlock() throws InterruptedException {
        AtomicInteger resourceCounter = new AtomicInteger(RESOURCE_CAPACITY);

        // Experimental group with locking
        ExecutorService experimentalGroupExecutor = Executors.newFixedThreadPool(5);
        AtomicInteger experimentalGroupCounter = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            experimentalGroupExecutor.submit(() -> {
                Lock locked = testClass.obtainLock("my-lock-key");
                if (locked.tryLock()) {
                    try {
                        // Simulating resource consumption
                        if (resourceCounter.getAndDecrement() > 0) {
                            experimentalGroupCounter.incrementAndGet();
                            logResourceUsage(Thread.currentThread().getId());
                        } else {
                            System.out.println("No more resources available.");
                        }
                    } finally {
                        testClass.unlock(locked);
                    }
                }
            });
        }

        // Control group without locking
        ExecutorService controlGroupExecutor = Executors.newFixedThreadPool(5);
        AtomicInteger controlGroupCounter = new AtomicInteger();

        for (int i = 0; i < 5; i++) {
            controlGroupExecutor.submit(() -> {
                // Simulating resource consumption without locking
                if (resourceCounter.getAndDecrement() > 0) {
                    controlGroupCounter.incrementAndGet();
                    logResourceUsage(Thread.currentThread().getId());
                } else {
                    System.out.println("No more resources available.");
                }
            });
        }

        // Shutdown the executors
        experimentalGroupExecutor.shutdown();
        controlGroupExecutor.shutdown();

        // Wait for the threads to complete
        experimentalGroupExecutor.awaitTermination(5, TimeUnit.SECONDS);
        controlGroupExecutor.awaitTermination(5, TimeUnit.SECONDS);

        // Print the results
        System.out.println("Experimental Group Counter: " + experimentalGroupCounter.get());
        System.out.println("Control Group Counter: " + controlGroupCounter.get());

        // Assertion: The experimental group should have consumed less than or equal to the resource capacity
        // The control group may exceed the capacity without locking
        assertEquals(0, experimentalGroupCounter.get());
        assertEquals(true, controlGroupCounter.get() < RESOURCE_CAPACITY);
    }

    private void logResourceUsage(long threadId) {
        System.out.println("Thread " + threadId + " consumed a resource.");
    }
}