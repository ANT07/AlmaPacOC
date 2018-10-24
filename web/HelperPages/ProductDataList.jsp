<%-- 
    Document   : ProductDataList
    Created on : 02-07-2018, 10:05:29 AM
    Author     : anthony
--%> 

<%@page import="com.oc.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.ProdutcImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <%
        ProdutcImpl productImpl = new ProdutcImpl();
        List<Product> products = productImpl.getProducts("from Product where productstate = 1");
        pageContext.setAttribute("products", products);
    %>
    <datalist id="products">
        <c:forEach var="product" items="${products}">
            <option value="${product.productid}" label="${product.productname}"></option>
        </c:forEach>
    </datalist>
    
    <input type="text" list="products" id="productid" name="productid" class="form-control input-sm" onblur="productName(event)">
    
