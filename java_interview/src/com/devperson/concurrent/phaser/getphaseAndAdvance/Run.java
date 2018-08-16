package com.devperson.concurrent.phaser.getphaseAndAdvance;


import com.devperson.concurrent.phaser.getphaseAndAdvance.thread.ThreadA;

public class Run {
    public static void main(String[] args) {
        MyPhase phase = new MyPhase(1);
        ThreadA threadA = new ThreadA(phase);
        threadA.start();
    }
}
