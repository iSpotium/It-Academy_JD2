package com.pvt.dao.daoImpl;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoUtils.AbstractJPADAO;
import com.pvt.dao.daoInterface.UserDAO;
import com.pvt.dao.entity.Role;
import com.pvt.dao.entity.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.pvt.dao.constants.UserConstants.*;

public class UserDAOImpl<T> extends AbstractJPADAO implements UserDAO<T> {

    private static UserDAOImpl instance;

    private UserDAOImpl(){

    }
    public static UserDAOImpl getInstance(){
        if(instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }


    @Override
    public void add(T user) throws LogDAOException {
        User addUser = (User) user;
        addUser.setUserRole(Role.USER);
        init();
        em.persist(addUser);
        close();
    }

    @Override
    public void delete(long id) {
        init();
        User user = em.getReference(User.class, id);
        em.remove(user);
        close();

    }

    @Override
    public T get(long id) {

        init();
        T user = (T) em.find(User.class, id);
        close();

        return user;
    }

    @Override
    public void changeData(T user) {
        User changeUser = (User) user;
        init();
        em.merge(changeUser);
        close();
    }


    @Override
    public User getUserByEmail(String userEmail) {
        User user;

        try {
            init();
            TypedQuery<User> namedQuery = em.createNamedQuery(GET_USER_BY_EMAIL, User.class).setParameter("userEmail", userEmail);
            user = namedQuery.getSingleResult();
            close();
        } catch (NoResultException e) {
            close();
            return null;
        }
        return user;
    }

    @Override
    public User getUserByName(String userName) {
        User user;

        try {
            init();
            TypedQuery<User> namedQuery = em.createNamedQuery(GET_USER_BY_NAME, User.class).setParameter("userName", userName);
            user = namedQuery.getSingleResult();
            close();
        } catch (NoResultException e) {
            close();
            return null;
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = null;

        try {
            init();
            TypedQuery<User> namedQuery = em.createNamedQuery(GET_ALL_USERS, User.class);
            usersList = namedQuery.getResultList();
            close();
        } catch (NoResultException e) {
            close();
            return null;
        }
        return usersList;
    }
}
