package com.pvt;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoUtils.DAOLogic;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceInterface.UserService;
import com.pvt.service.serviceImpl.UserServiceImpl;

import java.sql.SQLException;


public class Run {
    public static void main(String[] args) throws LogDAOException, SQLException {

        UserService<User> userService = UserServiceImpl.getInstance();
        //PostServiceImpl<Post> postService = PostServiceImpl.getInstance();
        DAOLogic daoLogic = DAOLogic.getInstance();

        User user = userService.getUserByName("user3");
        System.out.println(user.toString());


    }
}
