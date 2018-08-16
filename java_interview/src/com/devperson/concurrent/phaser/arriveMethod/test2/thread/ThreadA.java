package com.devperson.concurrent.phaser.arriveMethod.test2.thread;

import com.devperson.concurrent.phaser.arriveMethod.test2.TestArrive;

public class ThreadA extends Thread {
    private TestArrive testArrive;

    public ThreadA(TestArrive testArrive) {
        this.testArrive = testArrive;
    }

    @Override
    public void run() {
        testArrive.method1();
    }
}
