package com.pvt.dao.validation;

import com.pvt.dao.daoException.LogDAOException;

import java.sql.SQLException;

public class CheckTheData {
    public static boolean correctData(String[] data) throws LogDAOException, SQLException {

        Boolean[] saveFlags = new Boolean[3];

        if (UserValidation.isHaveUserWithUserName(data[0]) != true) {
            saveFlags[0] = true;
        } else {
            saveFlags[0] = false;
        }
        if (UserValidation.isPasswordCorrect(data[1]) == true) {
            saveFlags[1] = true;
        } else {
            saveFlags[1] = false;
        }
        if (UserValidation.isHaveUserWithUserEmail(data[2]) != true) {
            saveFlags[2] = true;
        } else {
            saveFlags[2] = false;
        }


        if (CheckTheData.indicator(saveFlags) != false){
            return true;
        }
            return false;
    }


    public static Boolean indicator(Boolean[] flags) {
        boolean indicator = false;

        for (Boolean i : flags) {
            if (i != false) {
                indicator = true;
            } else {
                indicator = false;
                break;
            }
        }
        return indicator;
    }
}
