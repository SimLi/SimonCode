package com.devperson.concurrent.phaser.thread;

import com.devperson.concurrent.phaser.PhaseTools;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread {
    private Phaser phaser;

    public ThreadB(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        super.run();
        PhaseTools.methodA();
    }
}
