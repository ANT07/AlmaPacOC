package com.oc.model;
// Generated 08-29-2018 02:13:27 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrderMaster generated by hbm2java
 */
public class OrderMaster  implements java.io.Serializable {


     private String orderid;
     private Contact contact;
     private Department department;
     private OrderType orderType;
     private Seller seller;
     private Date orderdate;
     private String ordercoment;
     private Float ordertotal;
     private Set orderDetails = new HashSet(0);

    public OrderMaster() {
    }

	
    public OrderMaster(String orderid, Contact contact, Department department, OrderType orderType, Seller seller) {
        this.orderid = orderid;
        this.contact = contact;
        this.department = department;
        this.orderType = orderType;
        this.seller = seller;
    }
    public OrderMaster(String orderid, Contact contact, Department department, OrderType orderType, Seller seller, Date orderdate, String ordercoment, Float ordertotal, Set orderDetails) {
       this.orderid = orderid;
       this.contact = contact;
       this.department = department;
       this.orderType = orderType;
       this.seller = seller;
       this.orderdate = orderdate;
       this.ordercoment = ordercoment;
       this.ordertotal = ordertotal;
       this.orderDetails = orderDetails;
    }
   
    public String getOrderid() {
        return this.orderid;
    }
    
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
    public Contact getContact() {
        return this.contact;
    }
    
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public OrderType getOrderType() {
        return this.orderType;
    }
    
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
    public Seller getSeller() {
        return this.seller;
    }
    
    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    public Date getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    public String getOrdercoment() {
        return this.ordercoment;
    }
    
    public void setOrdercoment(String ordercoment) {
        this.ordercoment = ordercoment;
    }
    public Float getOrdertotal() {
        return this.ordertotal;
    }
    
    public void setOrdertotal(Float ordertotal) {
        this.ordertotal = ordertotal;
    }
    public Set getOrderDetails() {
        return this.orderDetails;
    }
    
    public void setOrderDetails(Set orderDetails) {
        this.orderDetails = orderDetails;
    }




}

