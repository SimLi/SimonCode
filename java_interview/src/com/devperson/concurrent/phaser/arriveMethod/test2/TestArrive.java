package com.devperson.concurrent.phaser.arriveMethod.test2;

import java.util.concurrent.Phaser;

public class TestArrive {

    public TestArrive(Phaser myPhaseArriveMethod) {
        this.myPhaseArriveMethod = myPhaseArriveMethod;
    }

    Phaser myPhaseArriveMethod;

    public void method1() {

        try {
            System.out.println(Thread.currentThread().getName() + " 开始执行：" + System.currentTimeMillis() );
            Thread.sleep(3000);

            int s = (int)(Math.random() * 10000);
            System.out.println("s==" + s);
            Thread.sleep(s);

            System.out.println(Thread.currentThread().getName() + ".getPhase() == " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
            System.out.println(Thread.currentThread().getName() + ".getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
            System.out.println(Thread.currentThread().getName() + ".getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
            System.out.println(Thread.currentThread().getName() + ".getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());

            myPhaseArriveMethod.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + ".getPhase() 1== " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
            System.out.println(Thread.currentThread().getName() + ".getRegisteredParties() 1== " + myPhaseArriveMethod.getRegisteredParties());
            System.out.println(Thread.currentThread().getName() + ".getArrivedParties() 1== " + myPhaseArriveMethod.getArrivedParties());
            System.out.println(Thread.currentThread().getName() + ".getUnarrivedParties() 1== " + myPhaseArriveMethod.getUnarrivedParties());
            myPhaseArriveMethod.arriveAndAwaitAdvance();
            myPhaseArriveMethod.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " 开始执行：" + System.currentTimeMillis() );
        myPhaseArriveMethod.arrive();
        System.out.println(Thread.currentThread().getName() + ".getPhase() == " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
        System.out.println(Thread.currentThread().getName() + ".getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println(Thread.currentThread().getName() + ".getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println(Thread.currentThread().getName() + ".getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());

        myPhaseArriveMethod.arrive();
        System.out.println("myPhaseArriveMethod执行第二次");
        System.out.println(Thread.currentThread().getName() + ".getPhase() == " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
        System.out.println(Thread.currentThread().getName() + ".getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println(Thread.currentThread().getName() + ".getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println(Thread.currentThread().getName() + ".getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());

        myPhaseArriveMethod.arrive();
        System.out.println("myPhaseArriveMethod执行第三次");
        System.out.println(Thread.currentThread().getName() + ".getPhase() == " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
        System.out.println(Thread.currentThread().getName() + ".getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println(Thread.currentThread().getName() + ".getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println(Thread.currentThread().getName() + ".getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());

    }
}
