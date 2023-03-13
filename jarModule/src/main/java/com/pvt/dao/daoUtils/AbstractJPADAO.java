package com.pvt.dao.daoUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AbstractJPADAO {

    protected EntityManager em;

    public void init(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("It-Academy_JD2");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void close(){
        if(em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
        em.getEntityManagerFactory().close();
        em.close();
    }
}
