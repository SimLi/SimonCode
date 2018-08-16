package com.devperson.produmodel;

import java.util.Vector;

public class Consumer implements Runnable {

    private Vector shareQueue;
    private final int size ;

    public Consumer(Vector shareQueue, int size) {
        this.shareQueue = shareQueue;
        this.size = size;
    }

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
    @Override
    public void run() {
        while (true) {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consumer() throws InterruptedException{
        while (shareQueue.isEmpty()) {
            synchronized (shareQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + shareQueue.size());
                shareQueue.wait();
            }
        }

        synchronized (shareQueue) {
            shareQueue.notifyAll();
            System.out.println("消费者消费一条记录：" + shareQueue.get(0));
            shareQueue.remove(0); //出栈一条数据
        }
    }
}
