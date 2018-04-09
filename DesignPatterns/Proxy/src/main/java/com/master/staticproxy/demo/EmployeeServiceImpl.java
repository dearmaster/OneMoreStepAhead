package com.master.staticproxy.demo;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void add() {
        System.out.println("Added Employee");
    }

    @Override
    public void delete() {
        System.out.println("Delete Employee");
    }
}