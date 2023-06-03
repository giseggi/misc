package com.giseggi.misc.service.lock.impl;

import com.giseggi.misc.service.lock.LockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

import java.util.concurrent.locks.Lock;

@Component
@RequiredArgsConstructor
@Slf4j
public class LockServiceImpl implements LockService {

    private final RedisConnectionFactory redisConnectionFactory;

    @Override
    public Lock obtainLock(String lockKey) {
        RedisLockRegistry lockRegistry = new RedisLockRegistry(redisConnectionFactory, lockKey);
        return lockRegistry.obtain(lockKey);
    }

    @Override
    public void unlock(Lock lock) {
        try {
            lock.unlock();
        } catch (Exception e) {
            log.error("Failed to unlock. Reason: {}", e.getMessage());
        }
    }
}
