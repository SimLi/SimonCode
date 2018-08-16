package com.devperson.executors.自定义线程类;

public class MyThread extends Thread {

    public MyThread() {
        super();
    }

    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("自定义线程类->MyThread的run方法");
    }
}
