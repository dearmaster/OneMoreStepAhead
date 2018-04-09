package com.master.staticproxy.demo;

public class Boot {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceLogProxy(new EmployeeServiceExecutionTimeProxy(new EmployeeServiceImpl()));
        employeeService.add();
        employeeService.delete();
    }

}