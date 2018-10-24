/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.servlets;

import com.oc.dao.daoclases.SellerImpl;
import com.oc.model.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anthony
 */
public class SellerServlet extends HttpServlet {

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
            out.println("<title>Servlet SellerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SellerServlet at " + request.getContextPath() + "</h1>");
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
        int sellerid = Integer.parseInt(request.getParameter("sellerid"));
        String tipo = request.getParameter("tipo");
        String sellername = request.getParameter("sellername");
        int sellerstate = request.getParameter("sellerstate") != null ? 1 : 0;
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SellerView.jsp");
        
        Seller seller = new Seller();
        SellerImpl sellerImpl = new SellerImpl();
        

        seller.setSellername(sellername);
        seller.setSellerstate(sellerstate);
        
        try {
            switch(tipo){
                case  "guardar":
                        sellerImpl.insertSeller(seller);
                        break;
                case  "editar":
                        seller.setSellerid(sellerid);
                        sellerImpl.updateSeller(seller);
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
