package com.master.transaction.service.impl;

import com.master.transaction.dao.EmployeeDao;
import com.master.transaction.model.Employee;
import com.master.transaction.model.Payment;
import com.master.transaction.service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private PaymentServiceImpl paymentService;

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    @Override
    public void add(Employee employee, Payment payment) {
        paymentService.add(payment);
        this.add(employee);
    }

}