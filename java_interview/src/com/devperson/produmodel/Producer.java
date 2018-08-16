package com.devperson.produmodel;

import java.util.Vector;

public class Producer implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */

    private final Vector shareQueue; //生产者生产的消息存放
    private final int SIZE = 4; // 等待消费的消息队列长度

    public Producer (Vector shareQueue,int size) {
        this.shareQueue = shareQueue;
    }

    @Override
    public void run() {
        ThreadLocal<Integer> threadLocal = new ThreadLocal();
        threadLocal.set(1);
        while (true) {
            System.out.println("生产者上产消息中....." + threadLocal.get());
            try {
                produce(threadLocal.get());
                threadLocal.set(threadLocal.get() + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (shareQueue.size() == SIZE) {
            synchronized (shareQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + shareQueue.size());
                shareQueue.wait();
            }
        }

        synchronized (shareQueue) {
            shareQueue.add(i);
            shareQueue.notifyAll();
        }
    }
}
