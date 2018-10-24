/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Product;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOProduct {
    public void insertProduct(Product product) throws Exception;
    public void deleteProduct(Product product) throws Exception;
    public void updateProduct(Product product) throws Exception;
    public Product getProductById(String productId) throws Exception;
    public List<Product> getProducts(String hql) throws Exception;
}
