package com.oc.model;
// Generated 09-22-2018 03:02:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Roll generated by hbm2java
 */
public class Roll  implements java.io.Serializable {


     private int rollId;
     private String rollName;
     private Set usuarios = new HashSet(0);
     private Set rollSubmenus = new HashSet(0);

    public Roll() {
    }

	
    public Roll(int rollId, String rollName) {
        this.rollId = rollId;
        this.rollName = rollName;
    }
    public Roll(int rollId, String rollName, Set usuarios, Set rollSubmenus) {
       this.rollId = rollId;
       this.rollName = rollName;
       this.usuarios = usuarios;
       this.rollSubmenus = rollSubmenus;
    }
   
    public int getRollId() {
        return this.rollId;
    }
    
    public void setRollId(int rollId) {
        this.rollId = rollId;
    }
    public String getRollName() {
        return this.rollName;
    }
    
    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getRollSubmenus() {
        return this.rollSubmenus;
    }
    
    public void setRollSubmenus(Set rollSubmenus) {
        this.rollSubmenus = rollSubmenus;
    }




}


