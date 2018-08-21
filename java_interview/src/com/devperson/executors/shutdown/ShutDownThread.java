package com.devperson.executors.shutdown;

public class ShutDownThread implements Runnable
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  begin==" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
