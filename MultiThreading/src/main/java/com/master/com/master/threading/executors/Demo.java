package com.master.com.master.threading.executors;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        ConcurrentHashMap c;
        test1();
    }

    private static void test1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0; i<100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + " is running...");
                }
            });
        }
        executorService.shutdown();
    }

}