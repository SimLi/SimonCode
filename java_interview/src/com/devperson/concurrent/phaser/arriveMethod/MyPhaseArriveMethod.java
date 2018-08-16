package com.devperson.concurrent.phaser.arriveMethod;

import java.util.concurrent.Phaser;

public class MyPhaseArriveMethod extends Phaser {

    public MyPhaseArriveMethod() {
    }

    public MyPhaseArriveMethod(int parties) {
        super(parties);
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("MyPhaseArriveMethod的onAdvance被调用了");
        return super.onAdvance(phase, registeredParties);
    }
}
