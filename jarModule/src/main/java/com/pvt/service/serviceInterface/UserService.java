package com.pvt.service.serviceInterface;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service<User> {
    List<User> getAllUsers() throws LogDAOException, SQLException;
    User getUserByEmail(String userEmail) throws LogDAOException, SQLException;
    User getUserByName(String userName) throws LogDAOException, SQLException;
}
