package com.pvt.dao.daoInterface;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User> {

    User getUserByEmail(String userEmail) throws LogDAOException, SQLException;
    User getUserByName(String userName) throws LogDAOException, SQLException;
    List<User> getAllUsers() throws LogDAOException, SQLException;

}
