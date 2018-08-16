package com.devperson.concurrent.semaphore.methods.acquire;

import java.util.concurrent.Semaphore;

/**
 * 测试Semaphore的服务类
 * 其中Semaphore限制只能同时又一个线程执行方法
 * semaphore.acquire();和semaphore.release();之间的程序
 * Semaphore semaphore = new Semaphore(1);
 * 如果new Semaphore(int permits);的permits大于1的时候，该类不保证线程的安全性
 *
 * */
public class TestSemaphoerAcquireService2 {
    private Semaphore semaphore = new Semaphore(10);
    public void testMethod() {
        try {
            semaphore.acquire(2);
            semaphore.getQueueLength();
            semaphore.hasQueuedThreads();
            System.out.println(Thread.currentThread().getName() + "  开始时间：" + System.currentTimeMillis());
            int sleepValue =  ( (int) (Math.random() * 10000));
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " 线程，睡眠了==" + sleepValue +" 秒 ");
            System.out.println(Thread.currentThread().getName() + "  结束时间：" + System.currentTimeMillis());
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
