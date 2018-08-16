package com.devperson.concurrent.semaphore.SemaphorePool;

public class MyThread extends Thread {
    private ListPool listPool;

    public MyThread(ListPool listPool) {
        this.listPool = listPool;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String getString = listPool.get();
            //System.out.println("线程 " + Thread.currentThread().getName() + " 取得了 " + getString);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listPool.put(getString);
        }
    }
}
