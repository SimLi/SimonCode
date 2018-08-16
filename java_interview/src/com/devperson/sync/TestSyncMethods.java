package com.devperson.sync;

public class TestSyncMethods {

    public synchronized void methods1() throws InterruptedException {

        System.out.println("methods1方法执行");
        Thread.sleep(10000);


    }


    public synchronized void methods2() {
        System.out.println("methods2执行");
    }


}
