package com.master;

import java.util.ArrayList;
import java.util.List;

/**
 *-Xms10M -Xmx10M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOutOfMemoryErrorDemo {

    static class SampleTestObject {}

    /**
     * -XX:+HeapDumpOnOutOfMemoryError
     * This VM Option will ensure Heap info dump to file to the root of this project
     */
    public static void produceOutOfMemorryError() {
        List<SampleTestObject> list = new ArrayList<SampleTestObject>();
        while(true) {
            list.add(new SampleTestObject());
        }
    }

    /**jps find the <pid> of the current thread
     * jmap -dump:file=./heapDump.txt,format=b <pid>
     */
    public static void dynamicDumpHeapInRunTime() {
        List<SampleTestObject> list = new ArrayList<SampleTestObject>();
        while(true) {
            list.add(new SampleTestObject());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        produceOutOfMemorryError();
//        dynamicDumpHeapInRunTime();
    }

}