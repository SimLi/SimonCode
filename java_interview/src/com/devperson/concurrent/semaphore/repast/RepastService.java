package com.devperson.concurrent.semaphore.repast;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 提供生产与消费
 * */
public class RepastService {
    private Semaphore product = new Semaphore(10); // 10个生产者
    private Semaphore consume = new Semaphore(20); // 20个生产者
    volatile private ReentrantLock reentrantLock = new ReentrantLock();
    volatile private Condition productLock = reentrantLock.newCondition();
    volatile private Condition consumeLock = reentrantLock.newCondition();
    volatile private String[] productPosition = new String[4];

    /**
     * 判断存放产品数组中，是否为空，如果为空，则不允许进行消费
     * */
    private boolean isEmpty() {
        boolean isEmpty = true;
        for (String s : productPosition) {
            if (s != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    /**
     * 判断产品数组中，是否已经满了，如果满了则不允许生产
     * */
    private boolean isFull() {
        boolean isFull = true;
        for (String s : productPosition) {
            if (s == null) {
                isFull = false;
            }
        }
        return isFull;
    }

    /**
     * 生产商品
     * */
    public void product() {
        try {
            product.acquire();
            reentrantLock.lock();
            while (isFull()) { // 如果已经满了，则进入等待，等待消费者取出数据
                productLock.await();
            }
            for (int i = 0; i < productPosition.length; i++) { // 生产数据
                if (productPosition[i] == null) {
                    productPosition[i] = "产品1";
                    System.out.println("线程：" + Thread.currentThread().getName() + " 生产了数据 " + productPosition[i]);
                    break;
                }
            }
            consumeLock.signalAll();
            reentrantLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            product.release();
        }
    }

    public String consume() {
        try {
            consume.acquire();
            reentrantLock.lock();
            while (isEmpty()) {
                consumeLock.await();
            }
            for (int i = 0; i < productPosition.length; i++) {
                if (productPosition[i] != null) {
                    System.out.println("线程：" + Thread.currentThread().getName() + " 消费了数据 " + productPosition[i]);
                    productPosition[i] = null;
                    break;
                }
            }
            productLock.signalAll();
            reentrantLock.unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consume.release();
        }
        return "";
    }

}
