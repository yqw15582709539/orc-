package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Stream;

public class Dxc {

    public static void main(String[] args) throws Exception {


//        String [] A ={"2012.5.2","2000.1.1","2011.2.3","2020.2.3","2012.5.3"};
//        Stream<String> sorted = Arrays.stream(A).sorted((a, b) -> {
//            return a.compareTo(b);
//        });
//        sorted.forEach(System.out::println);
//        Arrays.stream(A).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);
//        String name = "XW";
//        String a = "{0}今年{1}岁了";
//        a = a.replace("{0}", name);
//        a = a.replace("{1}", "11");
//        System.out.println(a);

        long l = System.currentTimeMillis() / 1000 % 60;
        Thread add = new AddThread();
        Thread dec = new DecThread();
        add.start();
        dec.start();
//        System.out.println(Counter.count);
//        for (int i = 0; i < 1000000; i++) {
//            System.out.println(i);
//        }

        long l1 = System.currentTimeMillis() / 1000 % 60;
        System.out.println("---" + String.valueOf(l1 - l));

        System.out.println(Counter.count);
    }

}


class Counter {
    public static final Object looK = new Object();
    public static int count = 1;
    public static final Lock lock = new ReentrantLock();
    public static final ReentrantReadWriteLock getLock = new ReentrantReadWriteLock();
    public static final Condition c = lock.newCondition();
}

class AddThread extends Thread {
    public void run() {
//        for (int i = 0; i < 5000; i++) {
////            synchronized (Counter.looK) {
//            Counter.lock.lock();
//            try {
//
//                Counter.count -= 1;
//            } finally {
//                Counter.lock.unlock();
//            }
//
//        }
        while (Counter.count < 1000000) {
            synchronized (Counter.looK) {
                try {
                    Counter.count++;
                    System.out.println("a" + Counter.count);
                } finally {
                }
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
//        for (int i = 0; i < 10000; i++) {
//            Counter.lock.lock();
////            synchronized (Counter.looK) {
//            try {
//                Counter.count -= 1;
//            } finally {
//                Counter.lock.unlock();
//            }

        while (Counter.count < 1000000) {
            synchronized (Counter.looK) {
                try {
                    Counter.count++;
                    System.out.println("b" + Counter.count);
                } finally {

                }
            }
        }
    }
}

