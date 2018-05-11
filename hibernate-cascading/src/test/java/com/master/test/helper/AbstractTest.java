package com.master.test.helper;

import org.apache.log4j.Logger;

public abstract class AbstractTest {

    private static final Logger logger = Logger.getLogger(AbstractTest.class);

    protected void timeLogOutputExecute(TestCallback callback) {
        long startTime = System.currentTimeMillis();
        callback.doInAction();
        long endTime = System.currentTimeMillis();
        String method = new Exception().getStackTrace()[1].getMethodName();
        logger.info("Time cost for method [" + method + "]: " + (endTime - startTime));
    }

}