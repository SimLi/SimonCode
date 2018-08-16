package com.devperson.callable.p01;

import java.util.concurrent.Callable;

/**
 * Callable接口中泛型Callable<T> 就是线程中，返回的数据类型
 * */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("这是Callable执行");
        Thread.sleep(3000);
        return "这是Callable返回的信息";
    }
}
