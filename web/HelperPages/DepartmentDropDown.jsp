<%-- 
    Document   : DepartmentDropDown
    Created on : 02-07-2018, 10:23:29 AM
    Author     : anthony
--%>

<%@page import="com.oc.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.DepartmentImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<select name="departmentid" id="departmentid" class="form-control input-sm">
    <option value="-1" selected>Seleccione...</option>
    <%
        DepartmentImpl departmentImpl = new DepartmentImpl();
        List<Department> departments = departmentImpl.getDepartments("from Department where departemetstate = 1");
        pageContext.setAttribute("departmentList", departments);
    %>
    <c:forEach items="${departmentList}" var="department">
        <option value="${department.departmentid}">${department.departmentname}</option>
    </c:forEach>
</select>