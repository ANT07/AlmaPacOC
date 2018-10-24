package com.oc.model;
// Generated 09-22-2018 03:02:12 PM by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String usuario;
     private Roll roll;
     private String nombre;
     private String contrasena;

    public Usuario() {
    }

	
    public Usuario(String usuario) {
        this.usuario = usuario;
    }
    public Usuario(String usuario, Roll roll, String nombre, String contrasena) {
       this.usuario = usuario;
       this.roll = roll;
       this.nombre = nombre;
       this.contrasena = contrasena;
    }
   
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Roll getRoll() {
        return this.roll;
    }
    
    public void setRoll(Roll roll) {
        this.roll = roll;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }




}


