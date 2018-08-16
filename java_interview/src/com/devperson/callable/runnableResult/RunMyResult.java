package com.devperson.callable.runnableResult;

import java.util.concurrent.*;

public class RunMyResult {
    public static void main(String[] args) {
        String result = "这是传入的值";
        RunnableResult runnableResult = new RunnableResult(result);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        Future future = executor.submit(runnableResult,result);
        try {
            System.out.println("future的返回值=="+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
