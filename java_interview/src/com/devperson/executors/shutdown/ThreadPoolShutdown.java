package com.devperson.executors.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolShutdown {
    public static void main(String[] args) {
        ExecutorService poolExecutor = Executors.newCachedThreadPool();
        poolExecutor.execute(new ShutDownThread());
        poolExecutor.shutdown(); // 线程池，调用shutdown方法，线程池中的线程执行完成以后，就结束线程池
        try {
            poolExecutor.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
