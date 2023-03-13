package com.pvt.dao.daoFactory;

import com.pvt.dao.daoImpl.PostDAOImpl;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.daoInterface.DAO;

public class DAOFactory {
    private static DAOFactory instance;

    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        if(instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    public DAO getDAO(ObjectTypes ot) {

        DAO toReturn = null;

        switch (ot) {
            case USER:
                toReturn = UserDAOImpl.getInstance();
                break;
            case POST:
                toReturn = PostDAOImpl.getInstance();
                break;
        }
        return toReturn;
    }

}
