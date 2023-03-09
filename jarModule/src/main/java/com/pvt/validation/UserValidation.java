package com.pvt.validation;

import com.pvt.daoException.LogDAOException;
import com.pvt.daoImpl.UserDAOImpl;
import com.pvt.entity.Role;
import com.pvt.entity.User;

import java.sql.SQLException;

public class UserValidation {

    static UserDAOImpl userDAO = new UserDAOImpl();

    public static boolean isHaveUserWithUserName(String userName) throws LogDAOException, SQLException {
        if (userDAO.getUserByName(userName) == null) {
            return false;
        }
        return true;
    }


    public static boolean isPasswordCorrect(String userPassword) {
        String passwordPattern = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,}";

        return userPassword.matches(passwordPattern);
    }

    public static boolean isHaveUserWithUserEmail(String userEmail) throws LogDAOException, SQLException {
        if (userDAO.getUserByEmail(userEmail) == null) {
            return false;
        }
        return true;
    }
    public static boolean isRoleCorrect(User user){

        if (user.getUserRole() == Role.ADMIN || user.getUserRole() == Role.MODERATOR){
            return true;
        }
        return false;
    }
}
