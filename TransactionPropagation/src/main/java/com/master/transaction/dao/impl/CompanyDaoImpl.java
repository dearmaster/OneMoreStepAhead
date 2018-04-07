package com.master.transaction.dao.impl;

import com.master.transaction.dao.CompanyDao;
import com.master.transaction.dao.support.AbstractBaseDao;
import com.master.transaction.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends AbstractBaseDao<Company> implements CompanyDao {
}
