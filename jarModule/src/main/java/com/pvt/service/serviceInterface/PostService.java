package com.pvt.service.serviceInterface;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.Post;

import java.sql.SQLException;
import java.util.Set;

public interface PostService<T> extends Service<T>{
    Post getPostByName(String postName) throws LogDAOException, SQLException;
    Set<Post> getAllPosts();
    Set<Post> getPostsByUserId(long userId) throws LogDAOException, SQLException;
}

