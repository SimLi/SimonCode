package com.devperson.executors.线程池复用;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRun {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++ ) {
            executorService.execute(new MyThreadRunable());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 5; i++ ) {
            executorService.execute(new MyThreadRunable());
        }
    }
}
