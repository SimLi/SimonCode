package com.devperson.scheduledThreadPool.p03;

public class MyCallable04 implements Runnable {

    @Override
    public void run() {
        System.out.println("这是04周期执行线程");
        System.out.println(Thread.currentThread().getName() +  " 开始执行时间是:" + System.currentTimeMillis());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +  " 结束执行时间是:" + System.currentTimeMillis());

    }
}
