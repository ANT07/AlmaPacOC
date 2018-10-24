/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Usuario;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOUser {
        public void insertUser(Usuario user) throws Exception;
        public void deleteUser(Usuario user) throws Exception;
        public void updateUser(Usuario user) throws Exception;
        public Usuario getUserById(String userId) throws Exception;
        public List<Usuario> getUsers(String hql) throws Exception;
}
