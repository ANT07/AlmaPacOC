/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daoclases;

import com.oc.dao.NewHibernateUtil;
import com.oc.dao.daointerfaces.DAODepartment;
import com.oc.model.Department;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author anthony
 */
public class DepartmentImpl implements DAODepartment{


    @Override
    public void insertDepartment(Department department) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(department);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteDepartment(Department department) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(department);
        tx.commit();
        session.close();
    }

    @Override
    public void updateDepartment(Department department) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(department);
        tx.commit();
        session.close();
    }
    
    @Override
    public Department getDepartmentById(int departmentId) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Department department = (Department)session.get(Department.class, departmentId);
        session.close();
        return department;
    }
    
    @Override
    public List<Department> getDepartments(String hql) throws Exception {
        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List<Department> departments = query.list();
        return departments;
    }
}
