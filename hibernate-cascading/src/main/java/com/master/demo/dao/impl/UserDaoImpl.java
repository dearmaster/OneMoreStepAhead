package com.master.demo.dao.impl;

import com.master.demo.dao.UserDao;
import com.master.demo.dao.support.AbstractDaoSupport;
import com.master.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractDaoSupport<User> implements UserDao {

    @Override
    public List<User> load() {
        return super.load(User.class);
    }

}