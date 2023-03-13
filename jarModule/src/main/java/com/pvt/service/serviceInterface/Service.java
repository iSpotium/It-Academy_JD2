package com.pvt.service.serviceInterface;

import com.pvt.dao.daoException.LogDAOException;

public interface Service<T> {
    void add(T t) throws LogDAOException;
    void delete (long id) throws LogDAOException;
    T get (long id) throws LogDAOException;
    void changeData(T t);
}
