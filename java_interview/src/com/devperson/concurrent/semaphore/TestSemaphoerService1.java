package com.devperson.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 测试Semaphore的服务类
 * 其中Semaphore限制只能同时又一个线程执行方法
 * semaphore.acquire();和semaphore.release();之间的程序
 * Semaphore semaphore = new Semaphore(1);
 * 如果new Semaphore(int permits);的permits大于1的时候，该类不保证线程的安全性
 *
 * */
public class TestSemaphoerService1 {
    private Semaphore semaphore = new Semaphore(1);
    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "  开始时间：" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "  结束时间：" + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
