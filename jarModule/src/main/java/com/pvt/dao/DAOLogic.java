package com.pvt.dao;

import com.pvt.entity.User;

public class DAOLogic {
    private static final DAOLogic instance = new DAOLogic();

    private DAOLogic() {
    }

    public static DAOLogic getInstance() {
        return instance;
    }


    public User firstInitializationUser(String[] dataArray){
        User createdUser = new User();

        createdUser.setUserName(dataArray[0]);
        createdUser.setUserPassword(dataArray[1]);
        createdUser.setUserEmail(dataArray[2]);

        return createdUser;
    }
    public String[] splitString (String dataLine){

        String[] splitString;

        return splitString = dataLine.split(",");
    }
}
