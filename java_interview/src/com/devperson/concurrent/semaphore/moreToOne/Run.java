package com.devperson.concurrent.semaphore.moreToOne;

public class Run {
    public static void main(String[] args) {
//        Service service = new Service();
//        MyThread[] myThreads = new MyThread[10];
//        long start = System.currentTimeMillis();
//        for (int i = 0; i< myThreads.length; i++) {
//            myThreads[i] = new MyThread(service);
//            myThreads[i].start();
//        }
//        System.out.println("service执行时间为：" + (System.currentTimeMillis() - start)/1000 );
        // 线程 Thread-9执行时间为：20619

        Service1 service1 = new Service1();
        MyThread1[] myThreads1 = new MyThread1[10];
        long start1 = System.currentTimeMillis();
        for (int i = 0; i< myThreads1.length; i++) {
            myThreads1[i] = new MyThread1(service1);
            myThreads1[i].start();
        }
        System.out.println("service执行时间为：" + (System.currentTimeMillis() - start1)/1000 );
        // 线程1 Thread-9执行时间为：69641
    }
}
