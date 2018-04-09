package com.master.staticproxy.demo;

public class EmployeeServiceLogProxy implements EmployeeService {

    private EmployeeService employeeService;

    public EmployeeServiceLogProxy(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void add() {
        System.out.println("Adding process starts");
        employeeService.add();
        System.out.println("Adding process ends");
    }

    @Override
    public void delete() {
        System.out.println("Deleting process starts");
        employeeService.add();
        System.out.println("Deleting process ends");
    }
}