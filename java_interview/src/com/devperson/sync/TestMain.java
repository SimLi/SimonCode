package com.devperson.sync;

import java.util.concurrent.*;

public class TestMain {

    public static void main(String[] args) {
        TestSyncMethods testSyncMethods = new TestSyncMethods();

        Thread taskRunable1 = new Thread(new TaskRunable1(testSyncMethods));
        Thread taskRunable2 = new Thread(new TaskRunable2(testSyncMethods));
        taskRunable1.start();
        System.out.println("taskRunable1 执行完成");
        taskRunable2.start();
        System.out.println("taskRunable2 已启动.....");
        LinkedBlockingDeque blockingDeque = new LinkedBlockingDeque();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        ExecutorCompletionService executorCompletionService;
        ForkJoinPool forkJoinPool;

        copyOnWriteArrayList.add("李");
        copyOnWriteArrayList.add("小");
        copyOnWriteArrayList.add("蒙");
        copyOnWriteArrayList.add("爱");
        copyOnWriteArrayList.add("赵");
        copyOnWriteArrayList.add("晨");
        copyOnWriteArrayList.add("昭");



    }
}
