package com.master.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxySampleService implements InvocationHandler {

    private Object target;

    public DynamicProxySampleService(Object target) {
        this.target = target;
    }

//    public Object getProxyInstance() {
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
//    }

    public <T> T getProxyInstance() {
        T t =  (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        System.out.println(t.getClass() + ": " + t);
        return t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();
        return obj;
    }

    private void after() {
        System.out.println("After....");
    }

    private void before() {
        System.out.println("Before....");
    }

}