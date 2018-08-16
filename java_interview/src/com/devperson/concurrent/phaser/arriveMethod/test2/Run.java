package com.devperson.concurrent.phaser.arriveMethod.test2;

import com.devperson.concurrent.phaser.arriveMethod.test2.thread.ThreadA;
import com.devperson.concurrent.phaser.arriveMethod.test2.thread.ThreadB;
import com.devperson.concurrent.phaser.arriveMethod.test2.thread.ThreadC;

import java.util.concurrent.Phaser;

public class Run {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        TestArrive testArrive = new TestArrive(phaser);

        ThreadA threadA = new ThreadA(testArrive);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(testArrive);
        threadB.setName("B");
        threadB.start();

        ThreadC threadC = new ThreadC(testArrive);
        threadC.setName("C");
        threadC.start();
    }
}
