package com.master.transaction.dao.support;

import java.io.Serializable;

public interface IBaseDao<T> {

    Serializable add(T t);

}