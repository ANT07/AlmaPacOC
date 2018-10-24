/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 *
 * @author anthony
 */
public class ConexionPool {
    //@Resource(name="jdbc/miDataSource")amorrr
    static DataSource fuente;
    
    public static Connection getConnection(HttpServletRequest request){
        Connection connection = null;
        try {
            int serverPort = request.getServerPort();
            if(serverPort == 8080){
                InitialContext initCtx=new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource pool = (DataSource)envCtx.lookup("jdbc/miDataSource");
                connection = pool.getConnection();
            }else{
                InitialContext initCtx=new InitialContext();
                //Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource pool = (DataSource)initCtx.lookup("jdbc/OC");
                connection = pool.getConnection();
           }

        } catch (Exception ex) {
            Logger.getLogger(ConexionPool.class.getName()).log(Level.SEVERE, null, ex);
            connection = null;
        }
        
        return connection;
    } 
}
