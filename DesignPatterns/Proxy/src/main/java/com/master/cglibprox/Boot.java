package com.master.cglibprox;

public class Boot {

    public static void main(String[] args) {
        EmployeeService employeeService = new CglibProxyFactory(new EmployeeService()).getProxyInstance();
        PaymentService paymentService = new CglibProxyFactory(new PaymentService()).getProxyInstance();

        employeeService.add();
        employeeService.delete();

        paymentService.add();
        paymentService.delete();
    }

}