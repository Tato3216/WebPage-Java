<%@page import="modelo.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.validar"%>
<%@page import="modelo.interceptor"%>
<%@page import="java.util.HashMap"%>
<%@ page import="java.util.ArrayList" %>
<%validar val =new validar();%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class ="navbar navbar-dark bg-dark">
        <div class="dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            Menu
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="Clientes.jsp">Clientes</a>
                <a class="dropdown-item" href=<%=(val.getfrm())%>><%=(val.getnmv())%></a>
                <a class="dropdown-item" href="Recibos.jsp">Recibos de Venta</a>
                <a class="dropdown-item" href="Proveedores.jsp">Proveedores</a>
                <a class="dropdown-item" href="Compras.jsp">Compras</a>
                <a class="dropdown-item" href="Inventario.jsp">Inventario</a>
                <a class="dropdown-item" href="Usuarios.jsp">Usuarios</a>
                <a class="dropdown-item" href="Roles.jsp">Roles</a>
                <a class="dropdown-item" href="Accesos.jsp">Accesos</a>
                <a class="dropdown-item" href="Accesorol.jsp">Accesos a Roles</a>
            </div>
        </div>

            <div class="dropdown">
                <a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>
                <div class ="dropdown-menu text-center">
                    <a style="color: red; text-align: center" href="index.jsp"  class="dropdown-item">Salir</a>
                </div>
            </div>    
        </nav>  
        <h2><center> BIENVENIDO </center></h2>
<!--                        <select name="Drop" id="Drop" class="form">
                    <%
//                        interceptor inter = new interceptor();
//                        inter= new interceptor();
//                        HashMap<String,String> dropU = inter.iduser();
//                        for(String i: dropU.keySet()){
//                        out.println("<option value='" + i + "'>"+ dropU.get(i)+"</option>");
//                            }
                        %>
                   
                </select>-->
        <%
            out.println(val.getus() + val.getfrm());
            out.println(val.getcont());
//            String [] menu;
//            for (int i = 0; i < menu.length; i++) {
//            out.print("<P>" + menu[i] + "</p>");
//            System.out.println(m[i]);
            int conta = val.getcont();
//             %>
        <%
//            //In scriplets
              String [] namewin = new String[conta];
//             int i =0;
            out.print("Array Elements are:<br>");
            for (int i = 0; i < namewin.length; i++) {
       	    out.print(namewin[i] + ",");
		}
//            String[] strArr = new String[] {"1","2","3"};
		
//		String str = menu.toString();
//		
//		out.print("Java String array to String = "+str);
             %>
        
        <div class="dropdown-menu">
            
            <%
                        for (int i = 0; i < namewin.length; i++) {
                        out.print(namewin[i] + ",");
                %>
                <a class="dropdown-item" href="namewin">Clientes</a>
                <%
                        }
                %>
        </div>
        <table border="1" id="titleTable">
                
                <tr>
                    <td><a id="bt" type="button" value="title"</td>
                </tr>
                
            </table>
<!--                <table>
        <logic:iterate  name=<%=(val.getnmv())%> id=<%=(val.getfrm())%>  indexId="i">
             <tr>
                <td>Patient Name</td><td><bean:write name="print" property="pname"/></td>
            </tr>
                <tr>
                <td>Reference Bye</td><td><bean:write name="print" property="ref"/></td>
            </tr>
                <tr>
                <td>Token Number</td><td><bean:write name="print" property="tno"/></td>
            </tr>
                <tr>
                <td>age</td><td><bean:write name="print" property="age"/></td>
            </tr>
                <tr>
                <td>Sex</td><td><bean:write name="print" property="sex"/></td>
            </tr>
                <tr>
                <td>Cost</td><td><bean:write name="print" property="cost"/></td>
            </tr>
                <tr>
                <td>Counter Number</td><td><bean:write name="print" property="counter"/></td>
            </tr>
                <tr>
                <td>Visit no</td><td><bean:write name="print" property="vno"/></td>
            </tr>
                <tr>
                <td>Test Name</td><td></td>
            </tr>
                <tr>
                <td>Total Amount</td><td><bean:write name="print" property="amt"/></td>
            </tr>

        </logic:iterate>


        </table>-->
        <Table border="1">
         <tbody>
<!--             <tr> <td>Menu nombre</td><td>Menu formulario</td></td></tr>           -->
         </tbody>
        </Table>
        <%  
// retrieve your list from the request, with casting 
//        ArrayList<Menu> avitems = (ArrayList<Menu>) request.getAttribute("itemList");
//
//// print the information about every category of the list
//        for(Menu m : avitems) 
//        {
//   // do your work
//        }
//            ArrayList<String> m = (ArrayList<String>) request.getAttribute("studentDetailsList");
//
//            for(String s:m){
//
//            out.print(s);
//            }
//            <c:forEach step="2" being="0" end="${fn:length(array)}" varStatus="status">
//            ${items[varStatus.index]} - ${items[varStatus.index+1]}
//            </c:forEach>
            %>
            <center><img src="Las-trilogias-de-Iron-Man-Capitan-America-y-Thor-obtienen.jpg" alt=""width="700" height="350"/> </center>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
