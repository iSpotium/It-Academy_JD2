package com.pvt.dao.validation;

import com.pvt.dao.daoException.LogDAOException;

import java.sql.SQLException;

public class CheckTheData {
    public static boolean isTheDataCorrect(String[] data) throws LogDAOException, SQLException {

        Boolean[] validationStatuses = new Boolean[3];

        if (UserValidation.isHaveUserWithUserName(data[0]) != true) {
            validationStatuses[0] = true;
        } else {
            validationStatuses[0] = false;
        }
        if (UserValidation.isPasswordCorrect(data[1]) == true) {
            validationStatuses[1] = true;
        } else {
            validationStatuses[1] = false;
        }
        if (UserValidation.isHaveUserWithUserEmail(data[2]) != true) {
            validationStatuses[2] = true;
        } else {
            validationStatuses[2] = false;
        }


        return CheckTheData.isAllStatusCorrect(validationStatuses);
    }


    public static Boolean isAllStatusCorrect(Boolean[] validationStatuses) {
        boolean finalStatus = true;

        for (Boolean status : validationStatuses) {
            if (status == false) {
                finalStatus = false;
                break;
            }
        }
        return finalStatus;
    }
}
