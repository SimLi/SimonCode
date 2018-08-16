package com.devperson.concurrent.semaphore.methods.release;

import java.util.concurrent.Semaphore;

/**
 * semaphore.release();的调用，会在Semaphore构造的permits上加1或者permits
 * 所以多次调用semaphore.release();，可以动态增加Semaphore的permits
 * */
public class Run {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        System.out.println(semaphore.availablePermits());
        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
