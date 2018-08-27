package com.devperson.completionService.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCompletionServiceQueue {
    public static void main(String[] args) {
        CompletionCallable completionCallable = new CompletionCallable(1000);
        CompletionCallable completionCallable1 = new CompletionCallable(1500);
        CompletionCallable completionCallable2 = new CompletionCallable(1000);
        CompletionCallable completionCallable3 = new CompletionCallable(2500);
        CompletionCallable completionCallable4 = new CompletionCallable(2000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        BlockingQueue<Future> queuelist = new ArrayBlockingQueue<Future>(10);
        CompletionService completionService = new ExecutorCompletionService(executor,queuelist);
        List<CompletionCallable> list = new ArrayList();
        list.add(completionCallable);
        list.add(completionCallable1);
        list.add(completionCallable2);
        list.add(completionCallable3);
        list.add(completionCallable4);
        System.out.println("线程调用开始时间是 : " + System.currentTimeMillis());
        for (CompletionCallable callable : list) {
            completionService.submit(callable);
        }
//        System.out.println("线程长度===" + queuelist.size());
        while (queuelist.size() < 5 ) {
            // System.out.println("线程长度===" + queuelist.size());
            System.out.println("=========");
            for (Future future : queuelist) {
                try {
                    // System.out.println(completionService.take().get());
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        }
//        for (Future future : queuelist) {
//            try {
//                System.out.println(completionService.take().get());
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//        }
        System.out.println("执行结束了....");
    }
}
