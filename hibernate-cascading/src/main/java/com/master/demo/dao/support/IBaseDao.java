package com.master.demo.dao.support;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

    Serializable add(T t);

    void batchAdd(List<T> list);

    void delete(T t);

    void update(T t);

    List<T> load();

}