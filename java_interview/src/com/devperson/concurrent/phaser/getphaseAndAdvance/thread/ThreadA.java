package com.devperson.concurrent.phaser.getphaseAndAdvance.thread;

import java.util.concurrent.Phaser;

public class ThreadA extends Thread {
    private Phaser phaser;

    public ThreadA(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(" A begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("调用getPhase的值是：" + phaser.getPhase());

        System.out.println(" B begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("调用getPhase的值是：" + phaser.getPhase());

        System.out.println(" C begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("调用getPhase的值是：" + phaser.getPhase());

        System.out.println(" D begin");
        phaser.arriveAndAwaitAdvance();
        System.out.println("调用getPhase的值是：" + phaser.getPhase());

    }
}
