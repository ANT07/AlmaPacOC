/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daoclases;

import com.oc.dao.NewHibernateUtil;
import com.oc.dao.daointerfaces.DAOSeller;
import com.oc.model.Seller;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author anthony
 */
public class SellerImpl implements DAOSeller{
    
    @Override
    public void insertSeller(Seller seller) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(seller);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteSeller(Seller seller) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(seller);
        tx.commit();
        session.close();
    }

    @Override
    public void updateSeller(Seller seller) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(seller);
        tx.commit();
        session.close();
    }
    
    @Override
    public Seller getSellerById(int sellerId) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Seller seller = (Seller)session.get(Seller.class, sellerId);
        session.close();
        return seller;
    }
    
    @Override
    public List<Seller> getSellers(String hql) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Seller> sellers = query.list();
        return sellers;
    }
}
