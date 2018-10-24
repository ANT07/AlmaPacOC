package com.oc.model;
// Generated 08-29-2018 02:13:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Department generated by hbm2java
 */
public class Department  implements java.io.Serializable {


     private int departmentid;
     private String departmentname;
     private Integer departemetstate;
     private Set orderMasters = new HashSet(0);

    public Department() {
    }

    public Department(String departmentname, Integer departemetstate, Set orderMasters) {
       this.departmentname = departmentname;
       this.departemetstate = departemetstate;
       this.orderMasters = orderMasters;
    }
   
    public int getDepartmentid() {
        return this.departmentid;
    }
    
    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    public String getDepartmentname() {
        return this.departmentname;
    }
    
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
    public Integer getDepartemetstate() {
        return this.departemetstate;
    }
    
    public void setDepartemetstate(Integer departemetstate) {
        this.departemetstate = departemetstate;
    }
    public Set getOrderMasters() {
        return this.orderMasters;
    }
    
    public void setOrderMasters(Set orderMasters) {
        this.orderMasters = orderMasters;
    }




}


