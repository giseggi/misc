package com.giseggi.misc.service.schedule.impl;

import com.giseggi.misc.service.schedule.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    @Scheduled(cron = "0 0/15 * * * *")
    public void printLog() {
        log.debug("this message is printed every 15minutes by scheduler on {}", LocalDateTime.now());
    }
}
