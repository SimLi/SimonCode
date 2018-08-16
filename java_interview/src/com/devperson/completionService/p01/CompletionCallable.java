package com.devperson.completionService.p01;

import java.util.concurrent.Callable;

public class CompletionCallable implements Callable<String> {

    private int sleep;
    public CompletionCallable(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public String call() throws Exception {
        System.out.println(" 执行休眠时间是： " + sleep);
        Thread.sleep(sleep);
        return "返回值=" + Thread.currentThread().getName();
    }
}
