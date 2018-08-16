package com.devperson.completionService.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCompletionService  {
    public static void main(String[] args) {
        CompletionCallable completionCallable = new CompletionCallable(1000);
        CompletionCallable completionCallable1 = new CompletionCallable(1500);
        CompletionCallable completionCallable2 = new CompletionCallable(1000);
        CompletionCallable completionCallable3 = new CompletionCallable(2500);
        CompletionCallable completionCallable4 = new CompletionCallable(2000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        CompletionService completionService = new ExecutorCompletionService(executor);
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
        System.out.println("线程执行，调用完毕");
        System.out.println("线程调用完成时间是 : " + System.currentTimeMillis());
        System.out.println("获取线程调用返回值开始时间是 : " + System.currentTimeMillis());
//        for (CompletionCallable callable : list) {
//            try {
//                System.out.println(completionService.take().get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("获取线程调用返回值结束时间是 : " + System.currentTimeMillis());
        // 执行输出结果可看出，CompletionService执行是异步执行，take是阻塞执，那个线程先执行完毕，take就返回哪个线程
        /*线程调用开始时间是 : 1532958446319
        线程执行，调用完毕
        线程调用完成时间是 : 1532958446319
        获取线程调用返回值开始时间是 : 1532958446319
        执行休眠时间是： 1500
        执行休眠时间是： 1000
        执行休眠时间是： 1000
        执行休眠时间是： 2500
        执行休眠时间是： 2000
        返回值=pool-1-thread-1
        返回值=pool-1-thread-3
        返回值=pool-1-thread-2
        返回值=pool-1-thread-5
        返回值=pool-1-thread-4
        获取线程调用返回值结束时间是 : 1532958448834*/

        // 查看poll执行的结果
//        System.out.println("执行poll方法，非阻塞的");
//        System.out.println("poll开始==" + System.currentTimeMillis());
//        for (int i=0;i<5;i++) {
//            System.out.println(completionService.poll());
//        }
//        System.out.println("poll结束==" + System.currentTimeMillis());


/*        执行poll方法，非阻塞的
        poll开始==1532959001134
        null
        null
        执行休眠时间是： 1500
        执行休眠时间是： 1000
        null
        null
        执行休眠时间是： 2000
        执行休眠时间是： 2500
        null
        poll结束==1532959001134*/

        System.out.println("执行poll方法，非阻塞的，有最长等待时间的");
        System.out.println("poll开始==" + System.currentTimeMillis());
        for (int i=0;i<5;i++) {
            try {
                System.out.println(completionService.poll(1,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("poll结束,有最长等待时间的==" + System.currentTimeMillis());

/*        执行poll方法，非阻塞的，有最长等待时间的
        poll开始==1532959132408
        执行休眠时间是： 1500
        执行休眠时间是： 2500
        执行休眠时间是： 1000
        执行休眠时间是： 2000
        java.util.concurrent.FutureTask@4b67cf4d
        java.util.concurrent.FutureTask@7ea987ac
        java.util.concurrent.FutureTask@12a3a380
        java.util.concurrent.FutureTask@29453f44
        java.util.concurrent.FutureTask@5cad8086
        poll结束,有最长等待时间的==1532959134939*/

    }

}
