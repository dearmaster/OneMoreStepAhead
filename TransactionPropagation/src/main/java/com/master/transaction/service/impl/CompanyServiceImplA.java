package com.master.transaction.service.impl;

import com.master.transaction.dao.CompanyDao;
import com.master.transaction.model.Company;
import com.master.transaction.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//在Spring事务传播行为在内部方法不起作用?
@Service("companyServiceA")
public class CompanyServiceImplA implements CompanyService {

    @Autowired
    private CompanyDao companyDao;


    /**
     * Just for testing nested transaction
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void add(Company company) {
        Company company2 = new Company("HSBC");
        companyDao.add(company2);
        this.addAdditional();
        System.out.println(1/0);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void addAdditional() {
        Company company = new Company("Morgan");
        companyDao.add(company);
    }

}