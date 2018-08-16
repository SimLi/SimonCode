package com.devperson.concurrent.semaphore.repast;

public class MyThreadP extends Thread {
    private RepastService repastService;

    public MyThreadP(RepastService repastService) {
        this.repastService = repastService;
    }

    @Override
    public void run() {
        repastService.product();
    }
}
