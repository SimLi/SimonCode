package com.devperson.concurrent.semaphore.moreToOne;

public class MyThread1 extends Thread {
    private Service1 service1;

    public MyThread1(Service1 service1) {
        this.service1 = service1;
    }

    @Override
    public void run() {
        service1.sayHello();

    }
}
