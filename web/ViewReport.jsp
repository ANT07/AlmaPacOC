<%-- 
    Document   : ViewReport
    Created on : 05-25-2018, 03:43:11 PM
    Author     : anthony
--%>


<%@page import="com.oc.dao.ConexionPool"%>
<%@page import="javax.annotation.Resource"%>
<%@page import="javax.sql.DataSource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="net.sf.jasperreports.engine.*" %>

<!DOCTYPE html>


<%@include file="WEB-INF/jspf/ComprobarLoginReport.jspf"%>

<%    // captura del nombre del informe
    //archivos base
    File reportFile;
    Map parameters = new HashMap<String, Object>();
    String modulo = "";
    Connection conexion = ConexionPool.getConnection(request);

    modulo = "fac";
    String orderId = request.getParameter("orderId");
    parameters.put("ORDERID",
            orderId);

    reportFile = new File(application.getRealPath("Informes/Orderr.jasper"));
    // ruta del reporte, parametros y conexion

    byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),
            parameters,
            conexion);

    // generar pdf
    response.setContentType("application/pdf ; charset=UTF-8");
    response.setHeader("Content-Disposition",
            "inline; filename= Orderr.pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream ouputStream = response.getOutputStream();
    ouputStream.write(bytes,
            0,
            bytes.length);

    // limpiar y cerrar flujos de salida
    try {
        ouputStream.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }

    ouputStream.close();

    // cerrar conexion
    conexion.close();
%>


