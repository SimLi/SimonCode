package com.devfuns.core.execute;

public class MyRunable implements Runnable {

    private String name;

    private static int runableNum = 0;

    public MyRunable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是第" + runableNum + " 个 "  + Thread.currentThread().getName()+"运行");
        runableNum++;
    }
}
