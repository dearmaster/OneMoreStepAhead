package com.master.demo.dao.support;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractDaoSupport<T> implements IBaseDao<T> {

    private static final Logger logger = Logger.getLogger(AbstractDaoSupport.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(T t) {
        return this.execute(session -> {
//            logger.info("Insert " + t);
            return session.save(t);
        });
    }

    @Override
    public void batchAdd(List<T> list) {
        List<Integer> serializables = new ArrayList<>();
        int BATCH_UPDATE_SIZE = 50000;
        for(int i=0; i<list.size(); i++) {
            int finalI = i;
            Integer ret = this.execute(session -> {
                session.save(list.get(finalI));
                if(finalI % BATCH_UPDATE_SIZE == 0) {
                    logger.info("Batch insert commit.");
                    session.flush();
                    session.clear();
                }
                return null;
            });
            serializables.add(ret);

        }
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