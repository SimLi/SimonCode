package com.devperson.concurrent.phaser.arriveMethod;

public class Run {
    public static void main(String[] args) {
        MyPhaseArriveMethod myPhaseArriveMethod = new MyPhaseArriveMethod(2);
        System.out.println("myPhaseArriveMethod.getPhase() == " + myPhaseArriveMethod.getPhase() + " 栅栏 ");
        System.out.println("myPhaseArriveMethod.getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println("myPhaseArriveMethod.getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println("myPhaseArriveMethod.getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());
        // arrive的作用是使 arrivedParties加1，但是不再栅栏出等待，继续往下执行
        myPhaseArriveMethod.arrive();
        System.out.println("MyPhaseArriveMethod 执行过arrive ");
        System.out.println("myPhaseArriveMethod.getPhase() == " + myPhaseArriveMethod.getPhase()  + " 栅栏 ");
        System.out.println("myPhaseArriveMethod.getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println("myPhaseArriveMethod.getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println("myPhaseArriveMethod.getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());
        myPhaseArriveMethod.arrive();
        System.out.println("MyPhaseArriveMethod 执行过第二次 arrive");
        System.out.println("MyPhaseArriveMethod 执行过arrive ");
        System.out.println("myPhaseArriveMethod.getPhase() == " + myPhaseArriveMethod.getPhase()  + " 栅栏 ");
        System.out.println("myPhaseArriveMethod.getRegisteredParties() == " + myPhaseArriveMethod.getRegisteredParties());
        System.out.println("myPhaseArriveMethod.getArrivedParties() == " + myPhaseArriveMethod.getArrivedParties());
        System.out.println("myPhaseArriveMethod.getUnarrivedParties() == " + myPhaseArriveMethod.getUnarrivedParties());
    }
}
