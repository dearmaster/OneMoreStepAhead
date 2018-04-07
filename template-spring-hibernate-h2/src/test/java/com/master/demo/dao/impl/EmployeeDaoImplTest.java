package com.master.demo.dao.impl;

import com.master.demo.dao.EmployeeDao;
import com.master.demo.model.Employee;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/configuration/dataSource.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoImplTest {

    private static final Logger logger = LogManager.getLogger(EmployeeDaoImplTest.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void add() throws Exception {
        employeeDao.add(new Employee("Lucy"));
    }

}