package com.devperson.executors.自定义线程类;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRun {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
        executorService.execute(() ->{
            System.out.println("AAA");
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是new的接口");
            }
        });
    }
}
