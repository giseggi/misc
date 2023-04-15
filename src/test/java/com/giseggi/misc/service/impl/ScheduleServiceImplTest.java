package com.giseggi.misc.service.impl;

import com.giseggi.misc.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduleServiceImplTest {

    @Autowired
    private ScheduleService testClass;


    @Test
    void test() {
        testClass.printLog();
    }
}