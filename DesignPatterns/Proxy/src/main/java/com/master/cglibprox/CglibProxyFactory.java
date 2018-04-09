package com.master.cglibprox;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory {

    private Object obj;

    public CglibProxyFactory(Object obj) {
        this.obj = obj;
    }

    public <T> T getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("Starting...");
                method.invoke(obj, args);
                System.out.println("Ending...");
                System.out.println(proxy.getClass());
                return proxy;
            }
        });
        return (T) enhancer.create();
    }

}