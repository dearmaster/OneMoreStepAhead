package com.master.transaction.service.impl;

import com.master.transaction.model.Employee;
import com.master.transaction.model.Payment;
import com.master.transaction.service.EmployeeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Transactional
//@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/configuration/dataSource.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceImplTest {

    private static final Logger logger = LogManager.getLogger(EmployeeServiceImplTest.class);

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void add() throws Exception {
        Employee employee = new Employee("Lily222222222");
        Payment payment = new Payment("Salary");
        employeeService.add(employee, payment);
        logger.info("Saved " + employee + " and " + payment + " successfully!");
    }

}