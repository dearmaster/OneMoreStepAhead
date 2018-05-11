package com.master;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOutOfMemoryErrorDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i=0;
        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Throwable e) {
            System.out.println("There are " + i + " string objects in constant pool");
            e.printStackTrace();
        }
    }

}