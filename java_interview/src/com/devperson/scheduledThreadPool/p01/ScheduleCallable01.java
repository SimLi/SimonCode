package com.devperson.scheduledThreadPool.p01;

import java.util.concurrent.Callable;

public class ScheduleCallable01 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(" call 线程开始于： " + System.currentTimeMillis() + Thread.currentThread().getName());
        Thread.sleep(3000);
        System.out.println(" call 线程完成于： " + System.currentTimeMillis() + Thread.currentThread().getName());
        return "ReturnCallable01";
    }
}
