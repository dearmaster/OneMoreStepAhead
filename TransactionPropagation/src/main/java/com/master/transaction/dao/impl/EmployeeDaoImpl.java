package com.master.transaction.dao.impl;

import com.master.transaction.dao.EmployeeDao;
import com.master.transaction.dao.support.AbstractBaseDao;
import com.master.transaction.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractBaseDao<Employee> implements EmployeeDao {
}