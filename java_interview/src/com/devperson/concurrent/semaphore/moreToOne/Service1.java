package com.devperson.concurrent.semaphore.moreToOne;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多进路-单处理-多出路
 * 允许进入多个线程，同时值处理一个线程
 * */
public class Service1 {
    private Semaphore semaphore = new Semaphore(3);
    private ReentrantLock reentrantLock = new ReentrantLock();
    long time = 0;
    public void sayHello() {
        try {
            semaphore.acquire();
            long start1 = System.currentTimeMillis();
            System.out.println("线程1 " + Thread.currentThread().getName() + "准备");
            reentrantLock.lock(); // 添加锁，在unlock之前，只允许一个线程执行下面的语句
            System.out.println("开始 " + System.currentTimeMillis());
            for (int i = 0; i<5; i++) {// 次循环打印输出的，是有序形式，一个线程打印完成，另外一个线程才有可能执行打印
                System.out.println("线程1 " + Thread.currentThread().getName() + " 打印了：" + i);
                Thread.sleep(500);
            }
            time += (System.currentTimeMillis() - start1);
            reentrantLock.unlock();
            semaphore.release();
            System.out.println("线程1 " + Thread.currentThread().getName() + "结束");
            System.out.println("线程1 " + Thread.currentThread().getName() + "执行时间为：" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
