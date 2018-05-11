package com.master;

public class FinalizeEscapeGCDemo {

    private static FinalizeEscapeGCDemo HOOK = null;

    public static void main(String[] args) {
        HOOK = new FinalizeEscapeGCDemo();
        HOOK = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(null != HOOK) {
            HOOK.stillAlive();
        } else {
            System.out.println("I am dead");
        }

        //same peace of code below
        HOOK = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(null != HOOK) {
            HOOK.stillAlive();
        } else {
            System.out.println("I am dead");
        }
    }

    public void stillAlive() {
        System.out.println("I am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize method executed");
        FinalizeEscapeGCDemo.HOOK = this;
    }
}