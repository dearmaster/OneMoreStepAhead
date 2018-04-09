package com.master.dynamicproxy.demo;

public class PaymentServiceImpl implements SampleService {

    @Override
    public void add() {
        System.out.println("Payment added");
    }

    @Override
    public void delete() {
        System.out.println("Payment deleted");
    }

    @Override
    public void update() {
        System.out.println("Payment updated");
    }

}