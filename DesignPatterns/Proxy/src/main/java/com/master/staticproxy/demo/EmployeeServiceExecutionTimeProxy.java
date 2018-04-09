package com.master.staticproxy.demo;

public class EmployeeServiceExecutionTimeProxy implements EmployeeService {

    private EmployeeService employeeService;

    public EmployeeServiceExecutionTimeProxy(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void add() {
        long startTime = System.currentTimeMillis();
        employeeService.add();
        long endTime = System.currentTimeMillis();
        System.out.println("Time cost for adding employee: " + (endTime - startTime));
    }

    @Override
    public void delete() {
        long startTime = System.currentTimeMillis();
        employeeService.add();
        long endTime = System.currentTimeMillis();
        System.out.println("Time cost for deleting employee: " + (endTime - startTime));
    }
}