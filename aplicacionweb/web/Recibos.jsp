<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="modelo.recibos"%>
<%@page import="modelo.productos_list"%>
<%@page import="modelo.clientes_list"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recibos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario Recibos</h1>
            <div id="contenido">
                <br>
            <form action="srv_recibos" method="POST" class="form-group">
                <label for="lbl_id" ><b>ID</b></label> 
                <input type="text" name="txt_id" id="txt_id" class="form-control"  value="0" readonly>
                <label for="lbl_codigo" ><b>Numero de Documento</b></label>
                <input type="text" class="form-control" name="txt_documento" id ="txt_documento" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
                <label for="lbl_fecha"><b>Fecha:</b></label><!-- comment -->
                <input type="date" min="2022-01-01" max="2022-12-31" class="form-control" name="txt_fecha" id ="txt_fecha"  placeholder="2022-07-22" >
                <label for="lbl_cliente" ><b>Cliente</b></label>
                <select name="Drop_clientes" id="Drop_clientes" class="form-control">   
                    <%
                        clientes_list tcliente = new clientes_list();
                        tcliente= new clientes_list();
                        HashMap<String,String> dropT = tcliente.TipoC();
                        for(String i: dropT.keySet()){
                        out.println("<option value='" + i + "'>"+ dropT.get(i)+"</option>");
                            }
                        %>                   
                </select>
                <label for="lbl_nombre"><b>Descripcion</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_descripcion" id ="txt_descripcion"  >
                <label for="lbl_producto" ><b>Producto</b></label>
                <select name="Drop_productos" id="Drop_productos" class="form-control">
                    <%
                        productos_list prod = new productos_list();
                        prod= new productos_list();
                        HashMap<String,String> dropP = prod.proC();
                        for(String i: dropP.keySet()){
                        out.println("<option value='" + i + "'>"+ dropP.get(i)+"</option>");
                            }
                        %>
                </select>
                <label for="cantidad"><b>Cantidad</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_cantidad" id ="txt_cantidad"   >
                <label for="lbl_telefono"><b>Precio</b></label><!-- comment -->
                <input type="text" class="form-control" name="txt_precio" id ="txt_precio"  >
                <br>
                    <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                    <button name="btn_modificar" id="btn_modificar" value="Modificar" class="btn btn-succes" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" >Eliminar</button>
                    <button name="btncerrar" id="btncerrar" value="Salir" class="btn btn-succes">Salir</button>
            </form>
                        <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>No Documento</th>
                            <th>Cliente</th>
                            <th>Descripcion</th>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Fecha</th>
                            <th>Total</th>
                        </tr>  
                    <thead>
                    <tbody id="tbl_recibos">
                        <tr>
                            <%
                                recibos rec =new recibos();
                                DefaultTableModel tabla = new DefaultTableModel();
                                tabla = rec.leer();
                                for (int t=0;t<tabla.getRowCount();t++){
                                out.println("<tr data-id=" + tabla.getValueAt(t,0) +" data-id_t=" +tabla.getValueAt(t,10)+" data-id_p=" +tabla.getValueAt(t,8) + ">");
                                //out.println("<tr>");
                                out.println("<td>" + tabla.getValueAt(t,1) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,9) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,2) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,7) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,3) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,4) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,6) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,5) +"</td>");
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
           
               $('#tbl_recibos').on('click','tr td',function(evt){
               var target,id,id_t,id_p,doc,descripcion,cantidad,precio,fecha;
               target = $(event.target);
               id = target.parent().data('id');
               id_t = target.parent().data('id_t');
               id_p = target.parent().data('id_p');
               doc = target.parent("tr").find("td").eq(0).html();
               descripcion = target.parent("tr").find("td").eq(2).html();
               cantidad = target.parent("tr").find("td").eq(4).html();
               precio = target.parent("tr").find("td").eq(5).html();
               fecha = target.parent("tr").find("td").eq(6).html();
               $("#txt_id").val(id);
               $("#txt_documento").val(doc);
               $("#txt_descripcion").val(descripcion);
               $("#txt_cantidad").val(cantidad);
               $("#txt_precio").val(precio);
               $("#txt_fecha").val(fecha);
               $("#Drop_clientes").val(id_t);
               $("#Drop_productos").val(id_p);
           });
       </script>    
    </body>
</html>
