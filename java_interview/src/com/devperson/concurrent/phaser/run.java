package com.devperson.concurrent.phaser;

import com.devperson.concurrent.phaser.thread.ThreadA;
import com.devperson.concurrent.phaser.thread.ThreadB;
import com.devperson.concurrent.phaser.thread.ThreadC;

import java.util.concurrent.Phaser;

public class run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        PhaseTools.phaser = phaser;
        ThreadA threadA = new ThreadA(phaser);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(phaser);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(phaser);
        threadC.setName("C");
        threadC.start();

    }
}
