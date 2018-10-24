<%-- 
    Document   : OrderTypeView
    Created on : 02-06-2018, 10:48:59 AM
    Author     : anthony
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oc.model.OrderType"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.OrderTypeImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <%@include file="WEB-INF/jspf/ComprobarLogin.jspf"%>
        <%@include file="WEB-INF/jspf/NavBar.jspf"%>
        <%
            
            OrderTypeImpl types = new OrderTypeImpl();
            List<OrderType> typesList = types.getOrderTypes("from OrderType");
            pageContext.setAttribute("typeList", typesList);
        
        %>
        <div class="container">
            
            <div class="row">
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Tipo de Orden</h4>
                      </div>
                      <div class="modal-body">
                          <form action="TypeServlet" method="post" id="form">
                              <input name="tipo" id="tipo" value="guardar" type="hidden">
                              <input name="typeid" id="typeid" type="hidden" value="0">
                              <div class="form-group">
                                  <label>Nombre Tipo: </label>
                                  <input name="typename" id="typename" type="text" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label class="checkbox-inline">
                                      <input name="typestate" id="typestate" type="checkbox" value="Activo">Activo
                                  </label>
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-info" form="form" >Guardar</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8 col-md-offset-2">
                                    <!-- Button trigger modal -->
                <button type="button" class="btn btn-info btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="resetForm(),cambiarTipo()">
                    <span class="glyphicon glyphicon-plus"></span> Nuevo Tipo
                </button><br><br>
                <div>
                <div id="tableCont" class="table-responsive">
                    <table  class="table table-hover table-striped table-condensed">
                        <tr class="info"><th>Nombre Tipo</th><th>Estado</th><th>Acciones</th></tr>
                        <c:forEach items="${typeList}" var="type">
                                <tr>
                                    <td>${type.typename}</td>
                                    <td>
                                        <c:if test="${type.typestate == 1}">Activo</c:if>
                                        <c:if test="${type.typestate == 0}">Inactivo</c:if>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-info btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="abrirDialogoType('${type.typeid}','${type.typename}','${type.typestate}')">
                                            <span class="glyphicon glyphicon-edit"></span> Editar
                                        </button>
                                    </td>
                                </tr>
                        </c:forEach>
                    </table>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
