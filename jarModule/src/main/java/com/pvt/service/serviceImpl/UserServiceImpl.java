package com.pvt.service.serviceImpl;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoFactory.DAOFactory;
import com.pvt.dao.daoFactory.ObjectTypes;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.daoInterface.DAO;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceInterface.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DAO crudDAO = daoFactory.getDAO(ObjectTypes.USER);

    private static UserServiceImpl instance;

    private UserServiceImpl(){

    }
    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public void add(User user) throws LogDAOException {
        crudDAO.add(user);
    }

    @Override
    public void delete(long id) throws LogDAOException {
        crudDAO.delete(id);
    }

    @Override
    public User get(long id) throws LogDAOException {
        User user = (User) crudDAO.get(id);
        return user;
    }

    @Override
    public void changeData(User user) {
        crudDAO.changeData(user);
    }

    @Override
    public List<User> getAllUsers() {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();

        return userDAO.getAllUsers();
    }

    @Override
    public User getUserByEmail(String userEmail)  {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();

        return userDAO.getUserByEmail(userEmail);
    }

    @Override
    public User getUserByName(String userName) {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();

        return userDAO.getUserByName(userName);
    }
}
