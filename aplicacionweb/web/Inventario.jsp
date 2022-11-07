<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REPORTES</title>
    </head>
    <body>
        <form action="ReportePDF.jsp">
            <label for="lbl_fecha"><b>Desde</b></label><!-- comment -->
            <input type="date" min="2022-01-01" max="2022-12-31" class="form-control" name="txt_fecha1" id ="txt_fecha"  placeholder="2022-07-22" >
            <label for="lbl_fecha"><b>Hasta</b></label><!-- comment -->
            <input type="date" min="2022-01-01" max="2022-12-31" class="form-control" name="txt_fecha" id ="txt_fecha"  placeholder="2022-07-22" >
            <input type="submit" value ="Generar PDF">
        </form>    
        <%
            String datefrom;
            String dateto;
            datefrom=request.getParameter("txt_fecha1");
            dateto=request.getParameter("txt_fecha");
            %>
            
    </body>
</html>
