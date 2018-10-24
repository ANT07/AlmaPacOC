<%-- 
    Document   : ProviderDropDown
    Created on : 02-01-2018, 01:58:44 PM
    Author     : anthony
--%>

<%@page import="com.oc.model.Provider"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.ProviderImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<select name="providerid" id="providerid" class="form-control input-sm" >
    <option value="-1" selected>Seleccione...</option>
    <%
        ProviderImpl providerImpl = new ProviderImpl();
        List<Provider> providers = providerImpl.getProviders("from Provider");
        pageContext.setAttribute("providerList", providers);
    %>
    <c:forEach items="${providerList}" var="provider">
        <option value="${provider.providerid}">${provider.providername}</option>
    </c:forEach>
</select>
