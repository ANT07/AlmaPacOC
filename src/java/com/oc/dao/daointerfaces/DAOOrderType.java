/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.OrderType;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOOrderType {
    public void insertOrderType(OrderType orderType) throws Exception;
    public void deleteOrderType(OrderType orderType) throws Exception;
    public void updateOrderType(OrderType orderType) throws Exception;
    public OrderType getOrderTypeById(int orderTypeId) throws Exception;
    public List<OrderType> getOrderTypes(String hql) throws Exception;
}
