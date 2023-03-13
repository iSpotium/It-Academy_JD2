package com.pvt.dao.daoUtils;

import com.pvt.dao.entity.User;

public class DAOLogic {
    private static DAOLogic instance;

    private DAOLogic() {
    }

    public static DAOLogic getInstance() {
        if(instance == null){
            instance = new DAOLogic();
        }
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
