package com.devperson.concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 线程之间，交换数据，如果没有另外的线程来去数值，则线程进入阻塞
 * */
public class ThreadA extends Thread {
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(" 在线程以中，获取另外一个线程的值： " + exchanger.exchange("这是A的值"));
            exchanger.exchange("超时等待",10, TimeUnit.SECONDS);
            System.out.println("线程A结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
