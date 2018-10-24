/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao.daointerfaces;

import com.oc.model.OrderDetail;
import com.oc.model.OrderDetailId;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface DAOOrderDetail {
    public void insertOrderDetail(OrderDetail orderDetail) throws Exception;
    public void deleteOrderDetail(OrderDetail orderDetail) throws Exception;
    public void updateOrderDetail(OrderDetail orderDetail) throws Exception;
    public OrderDetail getOrderDetailById(OrderDetailId orderDetailId) throws Exception;
    public List<OrderDetail> getOrderDetails() throws Exception;
}
