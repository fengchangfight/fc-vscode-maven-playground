package com.fcvscodemvn.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRateDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            int num = i;
            threadPool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long end = System.currentTimeMillis();
                    System.err.println(
                            Thread.currentThread().getName() + "执行任务:" + num + " 间隔时间：" + (end - start) / 1000 + "秒");
                }

            }, 2, 5, TimeUnit.SECONDS);
            System.out.println("**");
        }

    }
}
