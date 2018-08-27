package com.devperson.scheduledThreadPool.p03;

import com.devperson.scheduledThreadPool.p02.MyCallable03;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyscheduleWithFixedDelay {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        MyCallable04 callable04 = new MyCallable04();
        MyCallable03 callable03 = new MyCallable03();

        // 延迟3秒，没2秒执行一次
        executorService.scheduleWithFixedDelay(callable04, 3L, 2L, TimeUnit.SECONDS);
        // executorService.scheduleWithFixedDelay(callable03, 3L, 2L, TimeUnit.SECONDS);

    }
}
