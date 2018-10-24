/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oc.servlets;

import com.oc.dao.daoclases.OrderDetailImpl;
import com.oc.dao.daoclases.OrdermasterImpl;
import com.oc.model.Contact;
import com.oc.model.ContactId;
import com.oc.model.Department;
import com.oc.model.OrderDetail;
import com.oc.model.OrderDetailId;
import com.oc.model.OrderMaster;
import com.oc.model.OrderType;
import com.oc.model.Product;
import com.oc.model.Provider;
import com.oc.model.Seller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
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
public class EditOrderServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditOrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println(
                    "<h1>Servlet EditOrderServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request,
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {
         try {
            String orderDate = request.getParameter("fecha");
            String orderId = request.getParameter("orderid");
            int providerId = Integer.parseInt(request.getParameter("providerid"));
            int contactId = Integer.parseInt(request.getParameter("contactid"));
            int typeId = Integer.parseInt(request.getParameter("typeid"));
            int sellerId = Integer.parseInt(request.getParameter("sellerid"));
            int departmentId = Integer.parseInt(request.getParameter("departmentid"));
            
            String comentario = request.getParameter("comentario");
            
            

            OrdermasterImpl orderMasterImpl = new OrdermasterImpl();
            
            OrderDetailImpl orderDetailImpl = new OrderDetailImpl();
            
            OrderMaster orderMaster = orderMasterImpl.getOrderMasterById(
                                orderId);
            
            Provider provider = new Provider();
            provider.setProviderid(providerId);
            Contact contact = new Contact();
            contact.setId(new ContactId(contactId,providerId));
            Seller seller = new Seller();
            seller.setSellerid(sellerId);
            OrderType orderType = new OrderType();
            orderType.setTypeid(typeId);
            Department department = new Department();
            department.setDepartmentid(departmentId);
            
            
            
            OrderDetail orderDetail;
            Set<OrderDetail> ordersDetails = new HashSet<OrderDetail>();
            String [] productsId = request.getParameterValues("productid");
            String [] cantidades = request.getParameterValues("cantidad");
            String [] preciosUnitatios = request.getParameterValues("precioUnitario");
            String [] productColors = request.getParameterValues("color");
            
            double total = 0;
            for(int i = 0; i< productsId.length; i++){
                orderDetail = new OrderDetail();
                orderDetail.setId(new OrderDetailId(i+1,orderId));
                orderDetail.setOrderdetailquantity(Float.parseFloat(cantidades[i]));
                orderDetail.setOrderdetailunitprice(Float.parseFloat(preciosUnitatios[i]));
                orderDetail.setProduct(new Product(productsId[i]));
                orderDetail.setOrderdetailtotal(orderDetail.getOrderdetailquantity() * orderDetail.getOrderdetailunitprice());
                orderDetail.setProductColor(productColors[i]);
                ordersDetails.add(orderDetail);
                total += orderDetail.getOrderdetailtotal();
            }
            
            orderMaster.setOrderid(orderId);
            orderMaster.setContact(contact);
            orderMaster.setDepartment(department);
            orderMaster.setOrderType(orderType);
            orderMaster.setOrdercoment(comentario);
            orderMaster.setSeller(seller);
            
            
            Set<OrderDetail> oldOrderDetalis = orderMaster.getOrderDetails();
            
            for(OrderDetail orderDetail1 : oldOrderDetalis){
                orderDetailImpl.deleteOrderDetail(orderDetail1);
            }
            
            orderMaster.setOrderDetails(ordersDetails);
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fecha = (java.util.Date)dateFormat.parse(orderDate);
            orderMaster.setOrderdate(dateFormat.parse(orderDate));
            
            orderMaster.setOrdertotal((float)total);
            
            orderMasterImpl.updateOrderMaster(orderMaster);
            
//            for(OrderDetail detail : ordersDetails){
//                orderDetailImpl.insertOrderDetail(detail);
//            }
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/OrdersView.jsp");
            requestDispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(NewOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NewOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
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

