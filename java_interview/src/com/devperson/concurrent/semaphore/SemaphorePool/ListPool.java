package com.devperson.concurrent.semaphore.SemaphorePool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListPool {
    private int poolMaxSize = 3;
    private int semaphorPer = 5;
    private List<String> list = new ArrayList<String>();
    private Semaphore semaphore = new Semaphore(semaphorPer);
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public ListPool() {
        super();
        for (int i = 0; i < poolMaxSize; i++ ) {
            list.add("李小蒙" + i);
        }
    }

    public String get() {
        String getString = null;
        try {
            semaphore.acquire();
            reentrantLock.lock();
            while (list.size() == 0) {
                condition.await();
            }
            getString = list.remove(0);
            System.out.println("线程 " + Thread.currentThread().getName() + " get了 " + getString);
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getString;
    }

    public void put(String str) {
        reentrantLock.lock();
        list.add(str);
        System.out.println("线程 " + Thread.currentThread().getName() + " put了 " + str);
        condition.signalAll();
        reentrantLock.unlock();
        semaphore.release();
    }
}
