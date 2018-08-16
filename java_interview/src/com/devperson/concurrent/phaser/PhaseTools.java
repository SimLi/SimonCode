package com.devperson.concurrent.phaser;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * Phaser和CountDownLatch，CyclicBarrier的功能使用类似
 * 此处用Phaser模拟阶段性赛跑的实现，查看一下Phaser的基本使用
 * */
public class PhaseTools {
    public static Phaser phaser;

    public static void methodA() {
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段A， begin=" + System.currentTimeMillis());
        // arriveAndAwaitAdvance方法的意思是，线程执行到该处以后，进行等待，然后当phaser符合继续运行的调教以后，继续往下运行
        phaser.arriveAndAwaitAdvance();
        // 输出，提示第一阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段A， end=" + System.currentTimeMillis());

        // 第二阶段赛跑开始
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段A， begin=" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();

        // 提示第二阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段A， end=" + System.currentTimeMillis());

    }

    public static void methodB() {
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段B， begin=" + System.currentTimeMillis());
        // arriveAndAwaitAdvance方法的意思是，线程执行到该处以后，进行等待，然后当phaser符合继续运行的调教以后，继续往下运行
        phaser.arriveAndAwaitAdvance();
        // 输出，提示第一阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段B， end=" + System.currentTimeMillis());

        // 第二阶段赛跑开始
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段B， begin=" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();

        // 提示第二阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段B， end=" + System.currentTimeMillis());
    }
}
