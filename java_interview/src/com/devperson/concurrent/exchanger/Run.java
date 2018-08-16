package com.devperson.concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA threadA = new ThreadA(exchanger); // 如果没有线程进入取出exchanger的值，则线程进入阻塞
        threadA.start();
        ThreadB threadB = new ThreadB(exchanger);
        threadB.start();
        System.out.println("主线程结束");
    }
}
