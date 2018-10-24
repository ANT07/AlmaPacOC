/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Seller;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOSeller {
        public void insertSeller(Seller seller) throws Exception;
        public void deleteSeller(Seller seller) throws Exception;
        public void updateSeller(Seller seller) throws Exception;
        public Seller getSellerById(int sellerId) throws Exception ;
        public List<Seller> getSellers(String hql) throws Exception;
}
