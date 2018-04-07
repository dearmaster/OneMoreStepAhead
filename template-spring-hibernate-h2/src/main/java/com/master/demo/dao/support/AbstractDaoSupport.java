package com.master.demo.dao.support;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractDaoSupport<T> implements IBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(T t) {
        return this.execute(session -> session.save(t));
    }

    @Override
    public void delete(T t) {
        this.execute((DaoCallBack<Void>) session -> {
            session.delete(t);
            return null;
        });
    }

    @Override
    public void update(T t) {
        this.execute((DaoCallBack<Void>) session -> {
            session.update(t);
            return null;
        });
    }

    public List<T> load(Class<T> c) {
        return this.execute(session -> {
            String hql = "from " + c.getSimpleName();
            return session.createQuery(hql).list();
        });
    }

    protected <R> R execute(DaoCallBack<R> callBack) {
        Session session = sessionFactory.getCurrentSession();
        return callBack.doInAction(session);
    }

}