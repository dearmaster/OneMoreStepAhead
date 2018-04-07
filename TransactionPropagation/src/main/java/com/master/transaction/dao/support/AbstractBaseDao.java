package com.master.transaction.dao.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class AbstractBaseDao<T> implements IBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(T t) {
        return this.execute(session -> session.save(t));
    }

    protected <R> R execute(DaoCallBack<R> callBack) {
        Session session = sessionFactory.getCurrentSession();
        return callBack.doInAction(session);
    }

}