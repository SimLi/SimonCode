package com.devperson.concurrent.phaser.arriveMethod.test2.thread;

import com.devperson.concurrent.phaser.arriveMethod.test2.TestArrive;

public class ThreadC extends Thread {
    private TestArrive testArrive;

    public ThreadC(TestArrive testArrive) {
        this.testArrive = testArrive;
    }

    @Override
    public void run() {
        testArrive.method2();
    }
}
