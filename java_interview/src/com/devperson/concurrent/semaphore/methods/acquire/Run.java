package com.devperson.concurrent.semaphore.methods.acquire;

public class Run {
    public static void main(String[] args) {
        TestSemaphoerAcquireService2 testSemaphoerAcquireService2 = new TestSemaphoerAcquireService2();
        Thread[] a = new Thread[10];
        for (int i = 0 ; i < 10; i++) {
            a[i] = new ThreadA(testSemaphoerAcquireService2);
            a[i].start();
        }
    }
}
