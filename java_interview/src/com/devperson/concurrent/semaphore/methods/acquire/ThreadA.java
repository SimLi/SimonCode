package com.devperson.concurrent.semaphore.methods.acquire;

public class ThreadA extends Thread {
    private TestSemaphoerAcquireService2 testSemaphoerAcquireService2;

    public ThreadA(TestSemaphoerAcquireService2 testSemaphoerAcquireService2) {
        this.testSemaphoerAcquireService2 = testSemaphoerAcquireService2;
    }

    @Override
    public void run() {
        testSemaphoerAcquireService2.testMethod();
    }
}
