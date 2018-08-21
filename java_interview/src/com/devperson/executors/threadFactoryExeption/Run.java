package com.devperson.executors.threadFactoryExeption;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) {
        // 程序执行输出的结果，应如下所示：线程中，出现未知异常，在自定义线程对象中，可以进行捕获
//        Simon's Wed Jul 25 22:43:54 CST 2018begin==1532529834036
//        java.lang.NullPointerException
//        Simon's Wed Jul 25 22:43:54 CST 2018 出现异常
//        自动以异常处理，异常信息是： null
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                new MyThreadFactoryA(),
                new ThreadPoolExecutor.DiscardPolicy());
        // set方式添加拒绝异常请求
        poolExecutor.setRejectedExecutionHandler((runnable, executor) -> {
            // runnable 被拒绝线程的对象
            // 线程执行器
        });

        poolExecutor.execute(() -> {
            System.out.println(Thread.currentThread().getName() +  "begin==" + System.currentTimeMillis());
            String 测试自定义异常 = null;
            测试自定义异常.indexOf(0);
        });


        ThreadPoolExecutor poolExecutor1 = new ThreadPoolExecutor(5,5,10L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                new MyThreadFactoryA(),
                new ThreadPoolExecutor.AbortPolicy() // 自定义线程拒绝策略
        );
    }
}
