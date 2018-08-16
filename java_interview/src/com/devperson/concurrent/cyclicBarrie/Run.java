package com.devperson.concurrent.cyclicBarrie;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) {
        // 设置同时5个线程并行，五个线程到达以后，执行cyclicBarrier中的Runable，
        // 然后继续执行线程后续的操作
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()-> {
            System.out.println("所有线程到达了，继续执行....");
        });

        MyCyclicBarrie[] array = new MyCyclicBarrie[5];
        for (int i = 0; i<array.length; i++) {
            array[i] = new MyCyclicBarrie(cyclicBarrier);
        }

        for (MyCyclicBarrie cyclicBarrie : array) {
            cyclicBarrie.start();
        }
        System.out.println("主线程执行结束");
    }
}

class MyCyclicBarrie extends Thread {
    private CyclicBarrier cyclicBarrier;

    public MyCyclicBarrie(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "开始了--" + System.currentTimeMillis());
            cyclicBarrier.await();
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "结束了--" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

//    主线程执行结束
//    Thread-0开始了--1534417054417
//    Thread-3开始了--1534417054535
//    Thread-1开始了--1534417054775
//    Thread-4开始了--1534417055015
//    Thread-2开始了--1534417055079
//    所有线程到达了，继续执行....
//    Thread-3结束了--1534417055411
//    Thread-2结束了--1534417055570
//    Thread-0结束了--1534417055730
//    Thread-4结束了--1534417055888
//    Thread-1结束了--1534417056049
}


