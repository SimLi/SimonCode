package com.devperson.executors.自定义线程类;


import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread = new MyThread(r);
        return myThread;
    }
}

