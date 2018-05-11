package com.master.demo.dao.impl;

import com.master.demo.dao.UserDao;
import com.master.demo.model.User;
import com.master.test.helper.AbstractTest;
import com.master.test.helper.MockUpHelper;
import com.master.test.helper.impl.MockUpHelperImpl;
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

import java.util.ArrayList;
import java.util.Set;

@Transactional
@Rollback(false)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/configuration/dataSource.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest extends AbstractTest {

    private static final Logger logger = LogManager.getLogger(UserDaoImplTest.class);

    @Autowired
    private UserDao userDao;

    private MockUpHelper mockUpHelper = MockUpHelperImpl.getInstance();

    /**
     * takes at least 67 seconds when insert 10w rows one by one
     */
    @Test
    public void add() throws Exception {
        Set<User> set = mockUpHelper.mockUp(User.class, 10000);
        super.timeLogOutputExecute(() -> {
            for(User user : set) {
                userDao.add(user);
            }
        });
    }

    /**
     * takes at least 48 seconds when insert 10w rows, batch size 5w
     * <br>
     * But when insert 1w ros, batch size 5w, will cost much more time that insert one by one
     * <br>
     * So, the performance of batch update usually not good
     */
    @Test
    public void batchAdd() throws Exception {
        Set<User> set = mockUpHelper.mockUp(User.class, 10000);
        super.timeLogOutputExecute(() -> {
            userDao.batchAdd(new ArrayList<>(set));
        });
    }

}