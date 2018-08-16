package com.devperson.concurrent.phaser.arriveAndDeregister.thread;

import com.devperson.concurrent.phaser.arriveAndDeregister.PrintTools;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread {
    private Phaser phaser;

    public ThreadB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        super.run();
        PrintTools.methodA();
    }
}
