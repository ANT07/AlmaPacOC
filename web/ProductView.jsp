<%-- 
    Document   : ProductView
    Created on : 05/02-2018, 05:07:38 PM
    Author     : anthony
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oc.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.ProdutcImpl"%>
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
            
            ProdutcImpl produtcs = new ProdutcImpl();
            List<Product> produtcsList = produtcs.getProducts("from Product");
            pageContext.setAttribute("produtcList", produtcsList);
        
        %>
        <div class="container">
            
            <div class="row">
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Productos</h4>
                      </div>
                      <div class="modal-body">
                          <form action="ProductServlet" method="post" id="form" >
                              <input name="tipo" id="tipo" value="guardar" type="hidden">
                              <div class="form-group">
                                  <label>Nombre Producto: </label>
                                  <input name="produtcname" id="produtcname" type="text" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label>codigo: </label>
                                  <input name="produtcid" id="produtcid" type="text" class="form-control" onkeypress="return onlyNumber(event,14)">
                              </div>
                              <div class="form-group">
                                  <label class="checkbox-inline">
                                      <input name="produtcstate" id="produtcstate" type="checkbox" value="Activo">Activo
                                  </label>
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-warning" form="form" >Guardar</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8 col-md-offset-2">
                                    <!-- Button trigger modal -->
                <button type="button" class="btn btn-warning btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="resetForm(),cambiarTipo(),habilitarText()">
                    <span class="glyphicon glyphicon-plus"></span> Nuevo Producto
                </button><br><br>
                <div class="table-responsive" id="tableCont">
                    <table  class="table table-hover table-striped table-condensed">
                        <tr class="warning"><th>Codigo</th><th>Nombre Producto</th><th>Estado</th><th>Acciones</th></tr>
                        <c:forEach items="${produtcList}" var="produtc">
                                <tr>
                                    <td>${produtc.productid}</td>
                                    <td>${produtc.productname}</td>
                                    <td>
                                        <c:if test="${produtc.productstate == 1}">Activo</c:if>
                                        <c:if test="${produtc.productstate == 0}">Inactivo</c:if>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-warning btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="abrirDialogoProduct('${produtc.productid}','${produtc.productname}','${produtc.productstate}')">
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
