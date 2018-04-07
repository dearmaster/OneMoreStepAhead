package com.master.demo.dao.impl;

import com.master.demo.dao.EmployeeDao;
import com.master.demo.dao.support.AbstractDaoSupport;
import com.master.demo.model.Employee;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractDaoSupport<Employee> implements EmployeeDao {

    @Override
    public List<Employee> load() {
        return super.load(Employee.class);
    }

}