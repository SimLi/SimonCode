package com.devperson.concurrent.phaser.arriveMethod.test2.thread;

import com.devperson.concurrent.phaser.arriveMethod.test2.TestArrive;

public class ThreadB extends Thread {
    private TestArrive testArrive;

    public ThreadB(TestArrive testArrive) {
        this.testArrive = testArrive;
    }

    @Override
    public void run() {
        testArrive.method1();
    }
}
