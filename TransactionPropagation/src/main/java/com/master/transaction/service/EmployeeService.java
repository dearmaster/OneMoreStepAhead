package com.master.transaction.service;

import com.master.transaction.model.Employee;
import com.master.transaction.model.Payment;

public interface EmployeeService {

    void add(Employee employee);
    void add(Employee employee, Payment payment);

}