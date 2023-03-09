package com.pvt;

import com.pvt.dao.DAOLogic;
import com.pvt.daoException.LogDAOException;
import com.pvt.daoImpl.UserDAOImpl;
import com.pvt.entity.Role;
import com.pvt.entity.User;
import com.pvt.validation.CheckTheData;
import com.pvt.validation.UserValidation;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Run {
    public static void main(String[] args) throws LogDAOException, SQLException {

        DAOLogic daoLogic = DAOLogic.getInstance();
        UserDAOImpl userDAO = new UserDAOImpl();

    }
}
