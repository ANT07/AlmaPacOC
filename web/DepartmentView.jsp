<%-- 
    Document   : DepartmentView
    Created on : 02-06-2018, 11:55:08 AM
    Author     : anthony
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oc.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.DepartmentImpl"%>
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
            
            DepartmentImpl departments = new DepartmentImpl();
            List<Department> departmentsList = departments.getDepartments("from Department");
            pageContext.setAttribute("departmentList", departmentsList);
        
        %>
        <div class="container">
            
            <div class="row">
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Departamentos</h4>
                      </div>
                      <div class="modal-body">
                          <form action="DepartmentServlet" method="post" id="form">
                              <input name="tipo" id="tipo" value="guardar" type="hidden">
                              <input name="departmentid" id="departmentid" type="hidden" value="0">
                              <div class="form-group">
                                  <label>Nombre Departamento: </label>
                                  <input name="departmentname" id="departmentname" type="text" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label class="checkbox-inline">
                                      <input name="departmentstate" id="departmentstate" type="checkbox" value="Activo">Activo
                                  </label>
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-link" form="form" >Guardar</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8 col-md-offset-2">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-link btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="resetForm(),cambiarTipo()">
                    <span class="glyphicon glyphicon-plus"></span> Nuevo Vendedor
                </button><br><br>
                <div>
                <div id="tableCont" class="table-responsive">
                    <table  class="table table-hover table-striped table-condensed">
                        <tr class="link"><th>Nombre Proveedor</th><th>Estado</th><th>Acciones</th></tr>
                        <c:forEach items="${departmentList}" var="department">
                                <tr>
                                    <td>${department.departmentname}</td>
                                    <td>
                                        <c:if test="${department.departemetstate == 1}">Activo</c:if>
                                        <c:if test="${department.departemetstate == 0}">Inactivo</c:if>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-link btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="abrirDialogoDepartment('${department.departmentid}','${department.departmentname}','${department.departemetstate}')">
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
        </div>
    </body>
</html>