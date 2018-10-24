/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.helpclases;

import com.oc.dao.daoclases.OrdermasterImpl;
import com.oc.model.OrderMaster;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anthony
 */
public class HelperClass {
    public static String getOrderId(){
        
        int orderCount ;
        String orderId = "";
        String anio = (""+(new GregorianCalendar().get(Calendar.YEAR))).substring(2,4);
        OrdermasterImpl orderMasterImpl = new OrdermasterImpl();
        try {
            List<OrderMaster> orderMasters = orderMasterImpl.getOrderMasters();
            orderCount = orderMasters.size()+1913;
            
            if(orderCount < 10){
                orderId = "0000"+orderCount;
            }
            else if(orderCount < 100){
                orderId = "000"+orderCount;
            }
            else if(orderCount < 1000){
                orderId = "00"+orderCount;
            }
            else if(orderCount < 10000){
                orderId = "0"+orderCount;
            }
        } catch (Exception ex) {
            Logger.getLogger(HelperClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return orderId+"-"+anio;
    }
    
}
