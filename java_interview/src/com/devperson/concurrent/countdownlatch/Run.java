package com.devperson.concurrent.countdownlatch;

public class Run {

    public static void main(String[] args) {
        MyServiceCountLatch myServiceCountLatch = new MyServiceCountLatch();
        MyThread myThread = new MyThread(myServiceCountLatch);
        myThread.start();
        myServiceCountLatch.downLatch();
    }
}
