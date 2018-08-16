package com.devperson.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyServiceCountLatch {
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void testMethod() {
        System.out.println("testMethod开始执行");
        try {
            countDownLatch.await();
            System.out.println("countDownLatch.await() 执行之后");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void downLatch() {
        System.out.println("downLatch开始执行");
        countDownLatch.countDown();
    }

}
