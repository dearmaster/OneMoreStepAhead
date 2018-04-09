package com.master.dynamicproxy.demo;

public class EmployeeServiceImpl implements SampleService {

    @Override
    public void add() {
        System.out.println("Employee added");
    }

    @Override
    public void delete() {
        System.out.println("Employee deleted");
    }

    @Override
    public void update() {
        System.out.println("Employee updated");
    }

}