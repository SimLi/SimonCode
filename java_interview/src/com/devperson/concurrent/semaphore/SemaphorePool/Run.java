package com.devperson.concurrent.semaphore.SemaphorePool;

public class Run {
    public static void main(String[] args) {
        ListPool listPool = new ListPool();

        MyThread[] myThreads = new MyThread[12];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(listPool);
        }

        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i].start();
        }
    }
}
