package com.devperson.concurrent.countdownlatch;

public class MyThread extends Thread {
    private MyServiceCountLatch myServiceCountLatch;

    public MyThread(MyServiceCountLatch myServiceCountLatch) {
        this.myServiceCountLatch = myServiceCountLatch;
    }

    @Override
    public void run() {

        myServiceCountLatch.testMethod();
    }
}
