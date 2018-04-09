package com.master.dynamicproxy.demo;

public class Boot {

    public static void main(String[] args) {
        SampleService service1 = new DynamicProxySampleService(new EmployeeServiceImpl()).getProxyInstance();
        SampleService service2 = new DynamicProxySampleService(new PaymentServiceImpl()).getProxyInstance();
        service1.add();
        service1.delete();
        service1.update();

        service2.add();
        service2.delete();
        service2.update();
    }

}