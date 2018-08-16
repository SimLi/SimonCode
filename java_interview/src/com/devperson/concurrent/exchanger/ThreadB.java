package com.devperson.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ThreadB extends Thread {
    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(" 在线程2中，获取另外一个线程的值： " + exchanger.exchange("这是B的值"));
            System.out.println("线程B结束");
            System.out.println(exchanger.exchange(null));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
