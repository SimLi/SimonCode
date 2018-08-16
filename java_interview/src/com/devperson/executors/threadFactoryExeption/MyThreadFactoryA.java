package com.devperson.executors.threadFactoryExeption;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactoryA implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("Simon's " + new Date());
        thread.setUncaughtExceptionHandler((curThread, exception) -> {
            System.out.println(curThread.getName()+" 出现异常");
            System.out.println(" 自动以异常处理，异常信息是： " + exception.getMessage());
            exception.printStackTrace();
        });
        return thread;
    }
}
