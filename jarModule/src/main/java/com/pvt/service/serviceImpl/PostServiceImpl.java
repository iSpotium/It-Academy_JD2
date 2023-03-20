package com.pvt.service.serviceImpl;

import com.pvt.dao.daoInterface.PostDAO;
import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoImpl.PostDAOImpl;
import com.pvt.dao.entity.Post;
import com.pvt.service.serviceInterface.PostService;

import java.sql.SQLException;
import java.util.Set;

public class PostServiceImpl<T> implements PostService<T> {

    private final PostDAO<Post> dao = PostDAOImpl.getInstance();

    private static PostServiceImpl instance;

    private PostServiceImpl(){

    }
    public static PostServiceImpl getInstance(){
        if(instance == null){
            instance = new PostServiceImpl<>();
        }
        return instance;
    }

    @Override
    public Post getPostByName(String postName) throws LogDAOException, SQLException {

        return dao.getPostByName(postName);
    }

    @Override
    public Set<Post> getAllPosts() {

        return dao.getAllPosts();
    }

    @Override
    public Set<Post> getPostsByUserId(long userId) {
        PostDAOImpl postDAO = PostDAOImpl.getInstance();

        return postDAO.getPostsByUserId(userId);
    }

    @Override
    public void add(T post) throws LogDAOException {
        dao.add((Post) post);
    }


    @Override
    public void delete(long id) throws LogDAOException {
        dao.delete(id);
    }

    @Override
    public T get(long id) throws LogDAOException {
        T post = (T) dao.get(id);
        return post;
    }

    @Override
    public void changeData(T post) {
        dao.changeData((Post) post);
    }
}
