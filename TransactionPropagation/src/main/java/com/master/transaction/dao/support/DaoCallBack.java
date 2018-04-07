package com.master.transaction.dao.support;

import org.hibernate.Session;

public interface DaoCallBack<T> {
    T doInAction(Session session);
}