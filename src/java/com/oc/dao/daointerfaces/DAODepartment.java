/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Department;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAODepartment {
    public void insertDepartment(Department department) throws Exception;
    public void deleteDepartment(Department department) throws Exception;
    public void updateDepartment(Department department) throws Exception;
    public Department getDepartmentById(int departmentId) throws Exception;
    public List<Department> getDepartments(String hql) throws Exception;
}
