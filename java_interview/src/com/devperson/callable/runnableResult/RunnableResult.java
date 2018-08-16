package com.devperson.callable.runnableResult;

public class RunnableResult implements Runnable {

    private String result;
    public RunnableResult(String result) {
        this.result = result;
    }

    @Override
    public void run() {
        System.out.println("这是runable的输出");
        System.out.println("传入的result的值是：" + result);
        this.result = "这是返回值";
    }
}
