package com.pvt.dao.daoInterface;

import com.pvt.dao.daoException.LogDAOException;

public interface DAO<T> {
    void add (T t) throws LogDAOException;
    void delete (long id) throws LogDAOException;
    T get (long id) throws LogDAOException;
    void changeData(T t);
}
