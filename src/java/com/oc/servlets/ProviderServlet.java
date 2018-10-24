/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.servlets;

import com.oc.dao.daoclases.ContactImpl;
import com.oc.dao.daoclases.ProviderImpl;
import com.oc.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anthony
 */
public class ProviderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Provider</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Provider at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int providerid = Integer.parseInt(request.getParameter("providerid"));
        String tipo = request.getParameter("tipo");
        String providername = request.getParameter("providername");
        int providerstate = request.getParameter("providerstate") != null ? 1 : 0;
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ProviderView.jsp");
        
        Provider provider = new Provider();
        ProviderImpl providerImpl = new ProviderImpl();
        

        provider.setProvidername(providername);
        provider.setProviderstate(providerstate);
        
        try {
            switch(tipo){
                case  "guardar":
                        providerImpl.insertProvider(provider);
                        
                        Contact contact = new Contact();
                        contact.setContactname(".");
                        contact.setPhone(".");
                        contact.setContactstate(1);
                        ContactImpl contactImpl = new ContactImpl();
                        List<Contact> contacts = contactImpl.getContacts("from Contact where providerid = " + provider.getProviderid());
                        
                        ContactId contactId = new ContactId();
                        contactId.setContactid(contacts.size());
                        contactId.setProviderid(provider.getProviderid());
                        
                        contact.setId(contactId);
                        
                        contactImpl.insertContact(contact);

                        break;
                case  "editar":
                        provider.setProviderid(providerid);
                        providerImpl.updateProvider(provider);
                        break;
                default:
                        throw new Exception("Error de operacion"+ this.getClass());
            }

            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
