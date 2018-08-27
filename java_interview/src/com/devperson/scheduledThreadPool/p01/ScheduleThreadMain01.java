package com.devperson.scheduledThreadPool.p01;

import java.util.concurrent.*;

public class ScheduleThreadMain01 {
    public static void main(String[] args) {
        ScheduleCallable01 callable01 = new ScheduleCallable01();
        ScheduleCallable02 callable02 = new ScheduleCallable02();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        System.out.println("主线程开始执行了.." + System.currentTimeMillis());
        ScheduledFuture<String> scheduledFuture1 = executorService.schedule(callable01,4L, TimeUnit.SECONDS); // 4秒以后执行
        ScheduledFuture<String> scheduledFuture2 = executorService.schedule(callable02,4L, TimeUnit.SECONDS); // 4秒以后执行
        System.out.println("主线程执行结束.....");
        try {
            System.out.println("线程A==" + scheduledFuture1.get());
            System.out.println("线程B==" + scheduledFuture2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
