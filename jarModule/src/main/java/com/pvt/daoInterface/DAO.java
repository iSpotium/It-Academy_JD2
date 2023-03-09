package com.pvt.daoInterface;

import com.pvt.daoException.LogDAOException;

public interface DAO<T> {
    void add (T t) throws LogDAOException;
    void delete (long userId) throws LogDAOException;
    T get (long userId) throws LogDAOException;
    void changeData(T t);
}
