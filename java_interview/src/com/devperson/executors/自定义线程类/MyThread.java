package com.devperson.executors.自定义线程类;

public class MyThread extends Thread {

    Runnable target;

    public MyThread(Runnable target) {
        super(target);
        this.target = target;
    }

    @Override
    public void run() {
        System.out.println("这是自定义的线程");
         target.run();
    }
}
