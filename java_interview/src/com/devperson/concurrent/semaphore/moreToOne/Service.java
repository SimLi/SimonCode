package com.devperson.concurrent.semaphore.moreToOne;

import java.util.concurrent.Semaphore;

/**
 * 多进路-多处理-多出路
 * 允许进入多个线程，同时处理多个线程，
 * */
public class Service {
    Semaphore semaphore = new Semaphore(3);
    long time = 0;

    public void sayHello() {
        try {
            semaphore.acquire();
            long start1 = System.currentTimeMillis();
            System.out.println("线程 " + Thread.currentThread().getName() + "准备");
            System.out.println("开始 " + System.currentTimeMillis());
            for (int i = 0; i<5; i++) { // 次循环打印输出的，有可能乱序形式,如下所示，单打印的乱序中，应该只包含 0,1,2；3,4,5;....
                /**
                 * 线程 Thread-2 打印了：0
                 线程 Thread-1 打印了：1
                 线程 Thread-0 打印了：1
                 线程 Thread-2 打印了：1
                 线程 Thread-2 打印了：2
                 线程 Thread-1 打印了：2
                 线程 Thread-0 打印了：2
                 线程 Thread-2 打印了：3
                 线程 Thread-0 打印了：3
                 线程 Thread-1 打印了：3
                 线程 Thread-2 打印了：4
                 线程 Thread-0 打印了：4
                 线程 Thread-1 打印了：4
                 * */
                System.out.println("线程 " + Thread.currentThread().getName() + " 打印了：" + i);
                Thread.sleep(500);
            }
            time += (System.currentTimeMillis() - start1);
            semaphore.release();
            System.out.println("线程 " + Thread.currentThread().getName() + "结束");
            System.out.println("线程 " + Thread.currentThread().getName() + "执行时间为：" + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
