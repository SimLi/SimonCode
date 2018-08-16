package com.devperson.concurrent.phaser.getphaseAndAdvance;

import java.util.concurrent.Phaser;

public class MyPhase extends Phaser {

    public MyPhase(int parties) {
        super(parties);
    }

    /**
     * onAdvance的作用是在通过屏障时，被调用
     * 返回true，线程不等待，Phaser的实例呈无效或销毁状态，后续的线程也将不再等待
     * 返回false，Phaser实例，继续起作用
     * */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("MyPhase的onAdvance被调用了....");
        return super.onAdvance(phase, registeredParties);
    }
}
