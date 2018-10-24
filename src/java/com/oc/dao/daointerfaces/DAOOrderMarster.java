/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.OrderMaster;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOOrderMarster {
    
        public void insertOrderMaster(OrderMaster orderMaster) throws Exception;
        public void deleteOrderMaster(OrderMaster orderMaster) throws Exception;
        public void updateOrderMaster(OrderMaster orderMaster) throws Exception;
        public OrderMaster getOrderMasterById(String orderMasterId) throws Exception;
        public List<OrderMaster> getOrderMasters() throws Exception;
}
