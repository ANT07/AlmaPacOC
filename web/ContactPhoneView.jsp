<%-- 
    Document   : ContactPhoneView
    Created on : 02-01-2018, 10:08:01 AM
    Author     : anthony
--%>

<%@page import="com.oc.model.Contact"%>
<%@page import="java.util.List"%>
<%@page import="com.oc.dao.daoclases.ContactImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>

        
    </head>
        <body>
        <%@include file="WEB-INF/jspf/ComprobarLogin.jspf"%>
        <%@include file="WEB-INF/jspf/NavBar.jspf"%>
        <script>

            $("#providerid").on("change",function(e){
                $("#providerId").val(e.target.value);
            });
            
        </script>
        <%
            
            ContactImpl contacts = new ContactImpl();
            List<Contact> contactsList = contacts.getContacts("from Contact");
            pageContext.setAttribute("contactList", contactsList);
        
        %>

        <div class="container">
            
            <div class="row">
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Contactos</h4>
                      </div>
                      <div class="modal-body">
                          <form action="ProviderPhoneServlet" method="get" id="form">
                              <input name="tipo" id="tipo" value="guardar" type="hidden">
                              <input name="contactid" id="contactid" type="hidden" value="0">
                              <div class="form-group">
                                  <label>Nombre Contacto: </label>
                                  <input type="text" name="contactname" id="contactname" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label>Proveedor: </label>
                                  <input type="hidden" name="providerId" value="" id="providerId" >
                                  <jsp:include page="HelperPages/ProviderDropDown.jsp"></jsp:include>
                              </div>
                              <div class="form-group">
                                  <label>Telefono de Contacto: </label>
                                  <input type="text" name="contactphone" id="contactphone" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label class="checkbox-inline">
                                      <input name="contactstate" id="contactstate" type="checkbox" value="Activo">Activo
                                  </label>
                              </div>
                          </form>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-success" form="form" >Guardar</button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-8 col-md-offset-2">
                                    <!-- Button trigger modal -->
<!--                <button type="button" class="btn btn-success btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="resetForm(),cambiarTipo(),habilitarSelect()">
                    <span class="glyphicon glyphicon-plus"></span> Nuevo Contacto
                </button><br><br>-->
                <div  id="tableCont" class="table-responsive">
                    <table  class="table table-hover table-striped table-condensed">
                        <tr class="success"><th>Nombre Contacto</th><th>Proveedor</th><th>Telefono</th><th>Estado</th><th>Acciones</th></tr>
                        <c:forEach items="${contactList}" var="contact">
                                <tr>
                                    <td>${contact.contactname}</td>
                                    <td>${contact.provider.providername}</td>
                                    <td>${contact.phone}</td>
                                    <td>
                                        <c:if test="${contact.contactstate == 1}">Activo</c:if>
                                        <c:if test="${contact.contactstate == 0}">Inactivo</c:if>
                                    </td>
                                    <td>
                                        <button type="button" class="btn btn-success btn-sm btn-block" data-toggle="modal" data-target="#myModal" onclick="abrirDialogoContact('${contact.id.contactid}','${contact.id.providerid}','${contact.contactname}','${contact.contactstate}','${contact.phone}')">
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
