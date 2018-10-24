/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daoclases;

import com.oc.dao.NewHibernateUtil;
import com.oc.dao.daointerfaces.DAOProduct;
import com.oc.model.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author anthony
 */
public class ProdutcImpl implements DAOProduct{
    
    @Override
    public void insertProduct(Product product) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteProduct(Product product) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
        session.close();
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
    }
    
    @Override
    public Product getProductById(String productId) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Product product = (Product)session.get(Product.class, productId);
        session.close();
        return product;
    }
    
    @Override
    public List<Product> getProducts(String hql) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        return products;
    }
}
