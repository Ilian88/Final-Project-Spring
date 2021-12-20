package com.example.healthy_way.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
public class Scheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    @Scheduled(cron = "*/10 * * * * *")
    public void showTime() {
        LOGGER.info("Current time is :" + LocalDateTime.now());
    }
}
