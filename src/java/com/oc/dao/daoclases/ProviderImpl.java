/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daoclases;

import com.oc.dao.NewHibernateUtil;
import com.oc.dao.daointerfaces.DAOProvider;
import com.oc.model.Provider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author anthony
 */
public class ProviderImpl implements DAOProvider{

    @Override
    public void insertProvider(Provider provider) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(provider);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteProvider(Provider provider) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(provider);
        tx.commit();
        session.close();
    }

    @Override
    public void updateProvider(Provider provider) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(provider);
        tx.commit();
        session.close();
    }
    
    @Override
    public Provider getProviderById(int providerId) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Provider provider = (Provider)session.get(Provider.class, providerId);
        session.close();
        return provider;
    }
    
    @Override
    public List<Provider> getProviders(String hql) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Provider> providers = query.list();
        return providers;
    }

    /*public List<Object []> getProviders() throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from provider");
        List<Object []> providers = query.list();

        return providers;
    }*/

}
