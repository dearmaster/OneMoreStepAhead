package com.master;

/**
 * -Xss128k
 */
public class StackOverFlowErrorDemo {

    static int stackLength = 1;

    public static void main(String[] args) throws Throwable {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length: " + stackLength);
            throw e;
        }
    }

    public static void stackLeak() {
        stackLength++;
        stackLeak();
    }

}