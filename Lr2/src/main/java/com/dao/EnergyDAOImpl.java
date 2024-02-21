package com.dao;

import com.model.Energy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Repository
public class EnergyDAOImpl implements EnergyDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Energy> allEnergys(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Energy").list();
    }

    @Override
    public void add(Energy energy) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(energy);
    }

    @Override
    public void delete(Energy energy){
        Session session = sessionFactory.getCurrentSession();
        session.delete(energy);
    }

    @Override
    public void edit(Energy energy){
        Session session = sessionFactory.getCurrentSession();
        session.update(energy);
    }

    @Override
    public Energy getById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Energy.class, id);
    }
}