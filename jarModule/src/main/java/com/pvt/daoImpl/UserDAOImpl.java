package com.pvt.daoImpl;

import com.pvt.dao.AbstractJPADAO;
import com.pvt.daoInterface.UserDAO;
import com.pvt.entity.Role;
import com.pvt.entity.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.pvt.constants.UserConstants.*;

public class UserDAOImpl extends AbstractJPADAO implements UserDAO {


    @Override
    public void add(User user) {
        user.setUserRole(Role.USER);
        init();
        em.persist(user);
        close();
    }

    @Override
    public void delete(long userId) {
        init();
        User user = em.getReference(User.class, userId);
        em.remove(user);
        close();

    }

    @Override
    public User get(long userId) {
        init();
        User user = em.find(User.class, userId);
        close();

        return user;
    }

    @Override
    public void changeData(User user) {
        init();
        em.merge(user);
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
