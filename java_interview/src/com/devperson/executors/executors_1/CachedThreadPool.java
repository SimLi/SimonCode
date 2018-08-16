package com.devperson.executors.executors_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    }
}
