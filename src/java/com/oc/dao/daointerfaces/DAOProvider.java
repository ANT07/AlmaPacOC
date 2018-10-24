/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.Provider;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOProvider {
    public void insertProvider(Provider provider) throws Exception;
    public void deleteProvider(Provider provider) throws Exception;
    public void updateProvider(Provider provider) throws Exception;
    public Provider getProviderById(int providerId) throws Exception;
    public List<Provider> getProviders(String hql) throws Exception;
}
