package com.devperson.scheduledThreadPool.p02;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyscheduleAtFixedRate {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        MyCallable03 callable03 = new MyCallable03();
        executorService.scheduleAtFixedRate(callable03, 3L, 2L, TimeUnit.SECONDS);
//        executorService.scheduleWithFixedDelay(callable03, 3L, 2L, TimeUnit.SECONDS);

    }
}
