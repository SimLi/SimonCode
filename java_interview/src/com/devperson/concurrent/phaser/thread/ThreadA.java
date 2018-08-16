package com.devperson.concurrent.phaser.thread;

import com.devperson.concurrent.phaser.PhaseTools;

import java.util.concurrent.Phaser;

public class ThreadA extends Thread {
    private Phaser phaser;

    public ThreadA(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        super.run();
        PhaseTools.methodA();
    }
}
