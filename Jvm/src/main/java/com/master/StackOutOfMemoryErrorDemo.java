package com.master;

/**
 *-Xms2G -Xmx2G -Xss1G -XX:+PrintGCDetails
 * 每个线程分配的栈内存越大越容易出现OutOfMemoryError
 */
public class StackOutOfMemoryErrorDemo {

    public static void main(String[] args) {
        stackLeakByThread();
    }

    public static void stackLeakByThread() {
        while(true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sleep();
                }
            }).start();
        }
    }

    private static void sleep() {
        try {
            System.out.println(Thread.currentThread().getName() + " sleeping....");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}