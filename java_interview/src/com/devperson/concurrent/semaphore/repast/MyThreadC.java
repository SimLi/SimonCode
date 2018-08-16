package com.devperson.concurrent.semaphore.repast;

public class MyThreadC extends Thread {
    private RepastService repastService;

    public MyThreadC(RepastService repastService) {
        this.repastService = repastService;
    }

    @Override
    public void run() {
        repastService.consume();
    }
}
