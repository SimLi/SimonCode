package com.devperson.concurrent.semaphore.thread;

import com.devperson.concurrent.semaphore.TestSemaphoerService1;
import com.devperson.concurrent.semaphore.TestSemaphoerService2;

public class ThreadC extends Thread {
    private TestSemaphoerService1 semaphoerService1;

    private TestSemaphoerService2 semaphoerService2;
    public ThreadC(TestSemaphoerService1 semaphoerService1) {
        super();
        this.semaphoerService1 = semaphoerService1;
    }

    public ThreadC(TestSemaphoerService2 semaphoerService2) {
        this.semaphoerService2 = semaphoerService2;
    }

    @Override
    public void run() {
//        semaphoerService1.testMethod();
        semaphoerService2.testMethod();
    }
}
