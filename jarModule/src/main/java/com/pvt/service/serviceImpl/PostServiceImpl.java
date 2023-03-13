package com.pvt.service.serviceImpl;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoFactory.DAOFactory;
import com.pvt.dao.daoFactory.ObjectTypes;
import com.pvt.dao.daoImpl.PostDAOImpl;
import com.pvt.dao.daoInterface.DAO;
import com.pvt.dao.entity.Post;
import com.pvt.service.serviceInterface.PostService;

import java.util.Set;

public class PostServiceImpl implements PostService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DAO crudDAO = daoFactory.getDAO(ObjectTypes.POST);

    private static PostServiceImpl instance;

    private PostServiceImpl(){

    }
    public static PostServiceImpl getInstance(){
        if(instance == null){
            instance = new PostServiceImpl();
        }
        return instance;
    }

    @Override
    public Post getPostByName(String postName) {
        PostDAOImpl postDAO = PostDAOImpl.getInstance();

        return postDAO.getPostByName(postName);
    }

    @Override
    public Set<Post> getAllPosts() {
        PostDAOImpl postDAO = PostDAOImpl.getInstance();

        return postDAO.getAllPosts();
    }

    @Override
    public Set<Post> getPostsByUserId(long userId) {
        PostDAOImpl postDAO = PostDAOImpl.getInstance();

        return postDAO.getPostsByUserId(userId);
    }

    @Override
    public void add(Post post) throws LogDAOException {
        crudDAO.add(post);
    }

    @Override
    public void delete(long id) throws LogDAOException {
        crudDAO.delete(id);
    }

    @Override
    public Post get(long id) throws LogDAOException {
        return (Post) crudDAO.get(id);
    }

    @Override
    public void changeData(Post post) {
        crudDAO.changeData(post);
    }
}
