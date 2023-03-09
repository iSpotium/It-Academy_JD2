package com.pvt.daoInterface;

import com.pvt.daoException.LogDAOException;
import com.pvt.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User>{

    User getUserByEmail(String userEmail) throws LogDAOException, SQLException;
    User getUserByName(String userName) throws LogDAOException, SQLException;
    List<User> getAllUsers() throws LogDAOException, SQLException;

}
