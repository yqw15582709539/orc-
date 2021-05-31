package com.example.demo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
	    // 一边吃饭一边喝酒
        new EatThread().start();
        new DrinkThread().start();
    }
}

class EatThread extends Thread{
    @Override
    public void run() {
        System.out.println("开始吃饭?...\t" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束吃饭?...\t" + new Date());
    }
}

class DrinkThread extends Thread {
    @Override
    public void run() {
        System.out.println("开始喝酒?️...\t" + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束喝酒?...\t" + new Date());
    }
}
