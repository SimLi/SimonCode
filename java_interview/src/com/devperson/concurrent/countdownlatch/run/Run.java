package com.devperson.concurrent.countdownlatch.run;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        CountDownLatch comintTag = new CountDownLatch(10);
        CountDownLatch waitTag = new CountDownLatch(1);
        CountDownLatch waitEndTag = new CountDownLatch(10);
        CountDownLatch waitRunTag = new CountDownLatch(1);
        CountDownLatch endTag = new CountDownLatch(10);
        RunThread[] threads = new RunThread[10];
        for (int i = 0; i < threads.length; i++) {
            RunThread runThread = new RunThread(comintTag,waitTag,waitRunTag,waitEndTag,endTag);
            threads[i] = runThread;
            runThread.start();
        }
        try {
            System.out.println("裁判等待所有线程到达");
            comintTag.await();
            System.out.println("所有线程，已到达起跑线...");
            System.out.println("起跑开始前，准备五秒");
            for (int i = 5; i >= 1; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            waitTag.countDown();
//            System.out.println("裁判喊了，预备，3秒准备....");
//            System.out.println(3);
//            Thread.sleep(4000);
//            System.out.println(2);
//            Thread.sleep(1000);
//            System.out.println(1);
            // Thread.sleep(1000);
            waitEndTag.await();
            waitRunTag.countDown();
            System.out.println("开始跑....");
            endTag.await();
            System.out.println("所有选手以到达终点");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
