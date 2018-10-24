<%-- 
    Document   : TypeDropDown
    Created on : 02-07-2018, 10:30:47 AM
    Author     : anthony
--%>

<%@page import="com.oc.model.OrderType"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.OrderTypeImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<select name="typeid" id="typeid" class="form-control input-sm">
    <option value="-1" selected>Seleccione...</option>
    <%
        OrderTypeImpl typeImpl = new OrderTypeImpl();
        List<OrderType> types = typeImpl.getOrderTypes("from OrderType where typestate = 1");
        pageContext.setAttribute("typeList", types);
    %>
    <c:forEach items="${typeList}" var="type">
        <option value="${type.typeid}">${type.typename}</option>
    </c:forEach>
</select>
