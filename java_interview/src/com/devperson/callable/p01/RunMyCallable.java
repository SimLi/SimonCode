package com.devperson.callable.p01;

import java.util.concurrent.*;

import static sun.swing.SwingUtilities2.submit;

public class RunMyCallable {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,
                5L, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        System.out.println("Callable开始调用了" + System.currentTimeMillis());
        Future<String> future = executor.submit(myCallable);
        try {
            System.out.println(future.get());
            System.out.println("future获取到了Callable的返回值" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 执行输出如下，根据执行时间和输出结果可以看出，调用future的get是阻塞的
        /*Callable开始调用了1532955924361
         这是Callable执行
        这是Callable返回的信息
        future获取到了Callable的返回值1532955927376
        */

    }
}
