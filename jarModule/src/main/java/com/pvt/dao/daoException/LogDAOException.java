package com.pvt.dao.daoException;

public class LogDAOException extends Exception {

    public LogDAOException() {
        super();
    }

    public LogDAOException(String message) {
        super(message);
    }

    public LogDAOException(Exception e) {
        super();
    }

    public LogDAOException(String message, Exception e) {
        super(message, e);
    }
}



