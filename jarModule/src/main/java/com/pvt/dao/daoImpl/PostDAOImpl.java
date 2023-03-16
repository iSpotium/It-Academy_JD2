package com.pvt.dao.daoImpl;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoUtils.AbstractJPADAO;
import com.pvt.dao.daoInterface.PostDAO;
import com.pvt.dao.entity.Post;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.pvt.dao.constants.PostConstants.*;

public class PostDAOImpl<T> extends AbstractJPADAO implements PostDAO<T> {

    private static PostDAOImpl instance;

    private PostDAOImpl(){

    }
    public static PostDAOImpl getInstance(){
        if(instance == null){
            instance = new PostDAOImpl<>();
        }
        return instance;
    }


    @Override
    public void add(T post) throws LogDAOException {

        Post addPost = (Post) post;
        init();
        em.persist(addPost);
        close();
    }

    @Override
    public void delete(long id) {
        init();
        Post post = em.getReference(Post.class, id);
        em.remove(post);
        close();
    }

    @Override
    public T get(long id) {

        init();
        T post = (T) em.find(Post.class, id);
        close();

        return post;
    }

    @Override
    public void changeData(T post) {

        init();
        em.merge(post);
        close();

    }

    @Override
    public Post getPostByName(String postName) {
        Post post;

        try {
            init();
            TypedQuery<Post> nq = em.createNamedQuery(GET_POST_BY_NAME, Post.class).setParameter("postName", postName);
            post = nq.getSingleResult();
            close();
        } catch (NoResultException e) {
            close();
            return null;
        }

        return post;
    }

    @Override
    public Set<Post> getAllPosts() {
        List<Post> allPosts = null;

        try {
            init();
            TypedQuery<Post> nq = em.createNamedQuery(GET_ALL_POSTS, Post.class);
            allPosts = nq.getResultList();
            close();
        } catch (NoResultException e){
            close();
            return null;
        }
        return new HashSet<>(allPosts);
    }

    @Override
    public Set<Post> getPostsByUserId (long userId) {

        List<Post> allPosts = null;

        try {
            init();
            TypedQuery<Post> nq = em.createNamedQuery(GET_POST_BY_USER_ID, Post.class).setParameter("userId", userId);
            allPosts = nq.getResultList();
            close();
        }catch (NoResultException e){
            close();
            return null;
        }

        return new HashSet<>(allPosts);
    }
}
