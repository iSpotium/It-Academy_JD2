package com.pvt.service.serviceImpl;

import com.pvt.dao.daoInterface.UserDAO;
import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceInterface.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl<T> implements UserService<T> {

    private final UserDAO<User> dao = UserDAOImpl.getInstance();

    private static UserServiceImpl instance;

    private UserServiceImpl(){

    }
    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl<>();
        }
        return instance;
    }

    @Override
    public void add(T user) throws LogDAOException {
        dao.add((User) user);
    }


    @Override
    public void delete(long id) throws LogDAOException {
        dao.delete(id);
    }

    @Override
    public T get(long id) throws LogDAOException {
        T user = (T) dao.get(id);
        return user;
    }


    @Override
    public void changeData(T user) {
        dao.changeData((User) user);
    }

    @Override
    public List<User> getAllUsers() throws LogDAOException, SQLException {
        return dao.getAllUsers();
    }

    @Override
    public User getUserByEmail(String userEmail) throws LogDAOException, SQLException {
        return dao.getUserByEmail(userEmail);
    }

    @Override
    public User getUserByName(String userName) throws LogDAOException, SQLException {

        return dao.getUserByName(userName);
    }
}
