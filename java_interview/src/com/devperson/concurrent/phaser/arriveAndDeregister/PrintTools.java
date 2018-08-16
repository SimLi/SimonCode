package com.devperson.concurrent.phaser.arriveAndDeregister;

import java.util.concurrent.Phaser;

/**
 * 测试arriveAndDeregister方法的使用
 * arriveAndDeregister是在当前线程到达以后，让Phaser的parties减1，
 * 使当前线程从Phaser中取消
 * */
public class PrintTools {
    public static Phaser phaser;

    public static void methodA() {
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段A， begin=" + System.currentTimeMillis());
        // arriveAndAwaitAdvance方法的意思是，线程执行到该处以后，进行等待，然后当phaser符合继续运行的调教以后，继续往下运行
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "线程-》A执行到第 " + phaser.getPhase());
        // 输出，提示第一阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段A， end=" + System.currentTimeMillis());

        // 第二阶段赛跑开始
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段A， begin=" + System.currentTimeMillis());
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "线程-》A执行到第 " + phaser.getPhase());
        // 提示第二阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第二阶段A， end=" + System.currentTimeMillis());

    }

    public static void methodB() {
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段B， begin=" + System.currentTimeMillis());
        // arriveAndAwaitAdvance方法的意思是，线程执行到该处以后，进行等待，然后当phaser符合继续运行的调教以后，继续往下运行
        System.out.println("运动员退出之前的拦截数: " + phaser.getRegisteredParties());
        phaser.arriveAndDeregister(); // 运动员，到达以后，退出比赛，即当前控制线程的Phaser中，减少一个线程数
        System.out.println(Thread.currentThread().getName() + "线程-》A执行到第 " + phaser.getPhase());
        // 输出，提示第一阶段赛跑结束
        System.out.println(Thread.currentThread().getName()+ " 执行第一阶段B， end=" + System.currentTimeMillis());

        System.out.println("运动员退出之后的拦截数: "+phaser.getRegisteredParties());
    }
}
