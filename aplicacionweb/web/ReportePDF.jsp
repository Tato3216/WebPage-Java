<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.io.*"%>
<%@page import ="java.util.*"%>
<%@page import ="net.sf.jasperreports.engine.*"%>
<%@page import ="net.sf.jasperreports.view.JasperViewer"%>
<%@page import ="javax.servlet.ServletResponse"%>
<%@page import ="net.sf.jasperreports.engine.*"%>
<%@page import ="java.sql.*"%>
<%@page import ="controlador.conexion"%>
<%@include file="Inventario.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        Connection con;
        conexion cn = new conexion();
        cn.abrirConexion();
        con=cn.getcon();
        File reportfile = new File (application.getRealPath("report2.jasper"));
        
        Map<String, Object> parameter = new HashMap<String, Object>();
//        Map parameter = new HashMap();
        String x =request.getParameter("txt_fecha1");
        parameter.put(datefrom,new String(x));
        String y =request.getParameter("txt_fecha");
        parameter.put(dateto,new String(y));
        byte [] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(),parameter,con);
        response.setContentType("application/pdf");
        response.setContentLength (bytes.length);
        ServletOutputStream outputstream = response.getOutputStream();
        outputstream.write(bytes,0, bytes.length);
        outputstream.flush();
        outputstream.close();
        
        %>
    </body>
</html>
