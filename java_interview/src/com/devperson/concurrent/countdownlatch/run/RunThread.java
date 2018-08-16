package com.devperson.concurrent.countdownlatch.run;

import java.util.concurrent.CountDownLatch;

public class RunThread extends Thread {
    private CountDownLatch comingTag; // 等待的人数，运动员人数
    private CountDownLatch waitTag; // 等待准备
    private CountDownLatch waitEndTag; // 运动员等待完毕标识，类似于准备完成起跑姿势
    private CountDownLatch waitRunTag; // 等待开始跑的命令，类似于开跑的枪声

    private CountDownLatch endTag; // 结束的标识

    public RunThread(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag,
                     CountDownLatch waitEndTag, CountDownLatch endTag) {
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.endTag = endTag;
        this.waitEndTag = waitEndTag;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName() + " 运动员开始进场");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " 运动员到起跑点了, 等待裁判准备命令");
            comingTag.countDown(); // 到达起跑点，等待标识减1,如果comingTag不等于0，则等待其他线程到达

            waitTag.await(); // 等待裁判准备命令
            System.out.println(Thread.currentThread().getName() + " 运动员准备完毕，准备起跑");
            waitEndTag.countDown(); // 运动员准备完成
            waitRunTag.await();
            System.out.println(Thread.currentThread().getName() + " 运动员开始起跑，起跑时间是 " +
                    System.currentTimeMillis() + " 耗时未知");
            int i = (int)(Math.random() * 10000);
            Thread.sleep(i);
            System.out.println(Thread.currentThread().getName() + " 运动员跑到终点， 耗时：" + i );
            endTag.countDown(); // 运动员到达，完成标识减1
            //System.out.println(Thread.currentThread().getName() + " 运动员到达终点 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
