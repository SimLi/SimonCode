package com.devperson.executors.executors_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            System.out.println("程序A开始于：" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println("A");
                System.out.println("程序A结束于：" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() ->{
            System.out.println("程序B开始于：" + System.currentTimeMillis());
            try {
                Thread.sleep(1000);
                System.out.println("B");
                System.out.println("程序B结束于：" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();


        // 使用自定义的线程工程
        ExecutorService myexecutorService = Executors.newCachedThreadPool(new MyThreadFactoryCaech());
        myexecutorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(" 我在运行自定义的线程工厂 ==" + Thread.currentThread().getName());
            }
        });
    }

    static class MyThreadFactoryCaech implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("这是我定义的线程" + System.currentTimeMillis());
            return thread;
        }
    }
}
