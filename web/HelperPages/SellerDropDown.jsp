<%-- 
    Document   : SellerDropDown
    Created on : 02-07-2018, 10:25:58 AM
    Author     : anthony
--%>

<%@page import="com.oc.model.Seller"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.SellerImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<select name="sellerid" id="sellerid" class="form-control input-sm">
    <option value="-1" selected>Seleccione...</option>
    <%
        SellerImpl sellerImpl = new SellerImpl();
        List<Seller> sellers = sellerImpl.getSellers("from Seller where sellerstate = 1");
        pageContext.setAttribute("sellerList", sellers);
    %>
    <c:forEach items="${sellerList}" var="seller">
        <option value="${seller.sellerid}">${seller.sellername}</option>
    </c:forEach>
</select>
