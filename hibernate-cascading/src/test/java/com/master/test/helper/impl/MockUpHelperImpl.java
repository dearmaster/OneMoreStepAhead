package com.master.test.helper.impl;

import com.master.demo.model.Gender;
import com.master.demo.model.Group;
import com.master.demo.model.User;
import com.master.test.helper.MockUpHelper;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public class MockUpHelperImpl implements MockUpHelper, InvocationHandler {

    private static final Integer MAX_NUMBER_OF_USERS = 100000;

    @Override
    public <T> Set<T> mockUp(Class<T> clas, int count) {
        Set<T> set = new HashSet<>();
        for(int i=0; i<count; i++) {
            set.add(mockUpObject(clas, i+1));
        }
        return set;
    }

    private <T> T mockUpObject(Class<T> clas, int i) {
        T t = null;
        if(clas == User.class) {
            t = (T) new User("mockup-" + i, Gender.F, "Shanghai", "lily.liu@hotmail.com", "15024831234");
        } else if(clas == Group.class) {
        } else if(clas == Gender.class) {
        }
        return t;
    }

    private static MockUpHelper instance;

    public static final MockUpHelper getInstance() {
        if(instance == null) {
            synchronized (MockUpHelperImpl.class) {
                if(instance == null) {
                    instance = getProxyInstance();
                }
            }
        }
        return instance;
    }


    private static final Logger logger = Logger.getLogger(MockUpHelperImpl.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ret = method.invoke(this, args);
        long endTime = System.currentTimeMillis();
        logger.info("Time cost for method [" + method.getName() + "]: " + (endTime - startTime));
        return ret;
    }

    public static MockUpHelper getProxyInstance() {
        return (MockUpHelper) Proxy.newProxyInstance(MockUpHelperImpl.class.getClassLoader(), MockUpHelperImpl.class.getInterfaces(), new MockUpHelperImpl());
    }

}