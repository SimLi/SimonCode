package com.devperson.concurrent.semaphore.repast;

public class Run {
    public static void main(String[] args) {
        RepastService repastService = new RepastService();
        MyThreadP[] myThreadPS = new MyThreadP[60];
        MyThreadC[] myThreadCS = new MyThreadC[60];
        for (int i = 0; i < myThreadCS.length; i++) {
            myThreadPS[i] = new MyThreadP(repastService);
            myThreadCS[i] = new MyThreadC(repastService);
        }

        for (int i = 0; i < myThreadPS.length; i++) {
            myThreadPS[i].start();
            myThreadCS[i].start();
        }


    }
}
