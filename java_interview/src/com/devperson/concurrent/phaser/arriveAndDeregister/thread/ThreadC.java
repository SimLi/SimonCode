package com.devperson.concurrent.phaser.arriveAndDeregister.thread;

import com.devperson.concurrent.phaser.arriveAndDeregister.PrintTools;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread {
    private Phaser phaser;

    public ThreadC(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        super.run();
        PrintTools.methodB();
    }
}
