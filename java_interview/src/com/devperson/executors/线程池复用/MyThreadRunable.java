package com.devperson.executors.线程池复用;

public class MyThreadRunable implements Runnable {
    @Override
    public void run() {
        Object s = new Object();
        System.out.println(Thread.currentThread().getName() + " 开始于：" + System.currentTimeMillis() + s);
    }
}
