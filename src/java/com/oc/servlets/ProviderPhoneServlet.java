/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.servlets;

import com.oc.dao.daoclases.ContactImpl;
import com.oc.model.Contact;
import com.oc.model.ContactId;
import com.oc.model.Provider;
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
public class ProviderPhoneServlet extends HttpServlet {

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
            out.println("<title>Servlet ProviderPhoneServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProviderPhoneServlet at " + request.getContextPath() + "</h1>");
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
                        response.setContentType("text/html");
                        this.doPost(request,
                response);

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
                    response.setContentType("text/html");
        String tipo = request.getParameter("tipo");
        ContactImpl contactImpl = new ContactImpl();
        if(tipo.equals("devolver")){
            try {
                String providerid = request.getParameter("providerid");
                List<Contact> contacts = contactImpl.getContacts("from Contact where providerid = " + providerid);
                //String respuesta = "<option value='-1'>Seleccionar...</option>";
                String respuesta = "";
                for(Contact contact : contacts){
                    respuesta += "<option value='"+contact.getId().getContactid()+"'>"+contact.getContactname()+"</option>";
                }
                PrintWriter out = response.getWriter();
                out.print(respuesta);
                return;
            } catch (Exception ex) {
                Logger.getLogger(ProviderPhoneServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ContactPhoneView.jsp");
        
        int providerid = Integer.parseInt(request.getParameter("providerId"));
        String contactname = request.getParameter("contactname");
        String contactphone = request.getParameter("contactphone");
        int contactstate = request.getParameter("contactstate") != null ? 1 : 0;
        
        Contact contact = new Contact();
        
        contact.setContactname(contactname);
        contact.setContactstate(contactstate);
        contact.setPhone(contactphone);
        
        
        try {
            ContactId contactId = new ContactId();
            switch(tipo){
                case "guardar":

                    List<Contact> contacts = contactImpl.getContacts("from Contact where providerid = " + providerid);
                    int numContacts = contacts.size()+1;
                    contactId.setContactid(numContacts);
                    contactId.setProviderid(providerid);
                    contact.setId(contactId);
                    contactImpl.insertContact(contact);
                    break;
                    
                case "editar":
                    
                    int contactid = Integer.parseInt(request.getParameter("contactid"));
                    contactId.setContactid(contactid);
                    contactId.setProviderid(providerid);
                    contact.setId(contactId);
                    contactImpl.updateContact(contact);
                    break;
            }
            
            requestDispatcher.forward(request, response);
        } catch (Exception e) {

            PrintWriter out = response.getWriter();
            out.print("<html>");
            out.print("<body>");
            out.print(e.getMessage()+ "\n"+ e);
            out.print("</body>");
            out.print("</html>");
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
