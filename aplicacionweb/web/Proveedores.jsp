<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="modelo.proveedor"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proveedores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario Proveedores</h1>
            <div id="contenido">
                <br>
            <form action="srv_proveedores" method="POST" class="form-group">
                <label for="lbl_id" ><b>ID</b></label> 
                <input type="text" name="txt_id" id="txt_id" class="form-control"  value="0" readonly>
                <label for="lbl_codigo" ><b>Nit</b></label>
                <input type="text" class="form-control" name="txt_nit" id ="txt_nit" placeholder="ejemplo:C00347" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
                <label for="lbl_nombre"><b>Nombre</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_name" id ="txt_name"  >
                <label for="apellido"><b>Apellidos:</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_lastname" id ="txt_lastname"   >
                <label for="lbl_telefono"><b>Telefono:</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_cel" id ="txt_cel"  >
                <label for="lbl_direccion"><b>Direccion:</b></label>
                <input type="text" class="form-control" name="txt_direccion" id ="txt_direccion"  >               
                    <br>
                    <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                    <button name="btn_modificar" id="btn_modificar" value="Modificar" class="btn btn-succes" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" >Eliminar</button>
                    <button name="btn_cerrar" id="btn_cerrar" value="Cerrar" class="btn btn-succes">Cerrar</button>
            </form>
                        <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nit</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                        </tr>  
                    <thead>
                    <tbody id="tbl_proveedores">
                        <tr>
                            <%
                                proveedor pro =new proveedor();
                                DefaultTableModel tabla = new DefaultTableModel();
                                tabla = pro.leer();
                                for (int t=0;t<tabla.getRowCount();t++){
                                out.println("<tr data-id=" + tabla.getValueAt(t,0) +" data-id_t=" +tabla.getValueAt(t,5) + ">");
                                //out.println("<tr>");
                                out.println("<td>" + tabla.getValueAt(t,1) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,2) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,3) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,4) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,5) +"</td>");
//                                out.println("<td>" + tabla.getValueAt(t,4) +"</td>");
//                                out.println("<td>" + tabla.getValueAt(t,6) +"</td>");
//                                out.println("<td>" + tabla.getValueAt(t,7) +"</td>");
                                out.println("</tr>");
                                }
                                %>
                        </tr>
                    </tbody>
                    </table>                            
                    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        </div>   
       <script type="text/javascript">
           
           $('#tbl_proveedores').on('click','tr td',function(evt){
               var target,id,nit,nombre,apellido,telefono,direccion;
               target = $(event.target);
               id = target.parent().data('id');
               id_t = target.parent().data('id_t');
               nit = target.parent("tr").find("td").eq(0).html();
               nombre = target.parent("tr").find("td").eq(1).html();
               apellido = target.parent("tr").find("td").eq(2).html();
               telefono = target.parent("tr").find("td").eq(3).html();
               direccion = target.parent("tr").find("td").eq(4).html();
               $("#txt_id").val(id);
               $("#txt_nit").val(nit);
               $("#txt_name").val(nombre);
               $("#txt_lastname").val(apellido);
               $("#txt_cel").val(telefono);
               $("#txt_direccion").val(direccion);
           });
       </script>    
    </body>
</html>
