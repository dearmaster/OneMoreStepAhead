package com.master.transaction.service.impl;

import com.master.transaction.service.CompanyService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Transactional
//@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/configuration/dataSource.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CompanyServiceImplATest {

    private static final Logger logger = LogManager.getLogger(CompanyServiceImplATest.class);

    @Autowired
    @Qualifier("companyServiceA")
    private CompanyService companyService;

    @Test
    public void add() throws Exception {
        companyService.add(null);
    }

}