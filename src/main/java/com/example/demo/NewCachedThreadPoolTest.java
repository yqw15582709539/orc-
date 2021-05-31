package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewCachedThreadPoolTest {

    public static void main(String[] args) {
//        // 创建一个可缓存线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 100; i++) {
//            try {
//                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cachedThreadPool.execute(new Runnable() {
//                public void run() {
//                    // 打印正在执行的缓存线程信息
//                    System.out.println(Thread.currentThread().getName()
//                            + "正在被执行");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }


//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(new Runnable() {
//                public void run() {
//                    try {
//                        // 打印正在执行的缓存线程信息
//                        System.out.println(Thread.currentThread().getName()
//                                + "正在被执行");
//                        Thread.sleep(6000);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                }}
//            });
//        }

        //创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
                 /*scheduledThreadPool.schedule(new Runnable() {
                     public void run() {
                        System.out.println("延迟1秒执行");
                     }
                 }, 1, TimeUnit.SECONDS);*/


        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }

}