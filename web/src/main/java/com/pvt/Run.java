package com.pvt;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoUtils.DAOLogic;
import com.pvt.dao.entity.Post;
import com.pvt.dao.entity.Role;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceImpl.PostServiceImpl;
import com.pvt.service.serviceImpl.UserServiceImpl;

import java.sql.SQLException;


public class Run {
    public static void main(String[] args) throws LogDAOException, SQLException {

        UserServiceImpl userService = UserServiceImpl.getInstance();
        PostServiceImpl postService = PostServiceImpl.getInstance();
        DAOLogic daoLogic = DAOLogic.getInstance();

        User user = userService.get(1);
        user.setUserRole(Role.ADMIN);
        userService.changeData(user);


    }
}
