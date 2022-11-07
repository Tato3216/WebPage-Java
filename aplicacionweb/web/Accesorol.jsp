<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="modelo.accesorol"%>
<%@page import="modelo.roles_list"%>
<%@page import="modelo.accesos_list"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>
    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accesos Rol</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <h1>Formulario de Accesos de Rol</h1>
            <div id="contenido">
                <br>
            <form action="srv_accesorol" method="POST" class="form-group">
                <label for="lbl_id" ><b>ID</b></label> 
                <input type="text" size=40 style="width:500px" name="txt_id" id="txt_id" class="form-control"  value="0" readonly>
                <label for="lbl_name"><b>ROL:</b></label><!-- comment -->
                <select name="Drop_rol" id="Drop_rol" class="form-control">
                    <%
                        roles_list ro = new roles_list();
                        ro = new roles_list();
                        HashMap<String,String> dropC = ro.RolU();
                        for(String i: dropC.keySet()){
                        out.println("<option value='" + i + "'>"+ dropC.get(i)+"</option>");
                            }
                        %>
                   
                </select>
                <label for="lbl_usuario"><b>Acceso (ventana):</b></label><!-- comment -->        
                <select name="Drop_acceso" id="Drop_acceso" class="form-control">
                    <%
                        accesos_list ac = new accesos_list();
                        ac = new accesos_list();
                        HashMap<String,String> dropB = ac.AccesU();
                        for(String i: dropB.keySet()){
                        out.println("<option value='" + i + "'>"+ dropB.get(i)+"</option>");
                            }
                        %>
                   
                </select>
                
                    <br>
                    <button name="btnagregar" id="btnagregar" value="Agregar" class="btn btn-primary">Agregar</button>
                    <button name="btn_modificar" id="btn_modificar" value="Modificar" class="btn btn-succes" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Modificar</button>
                    <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" >Eliminar</button>
                    <button name="btn_cerrar" id="btn_cerrar" value="Cerrar" class="btn btn-succes">Cerrar</button>
            </form>
                        <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Usuario</th>
                            <th>Rol</th>
                            <th>Clave</th>
                        </tr>  
                    <thead>
                    <tbody id="tbl_accesosrol">
                        <tr>
                            <%
                                accesorol accr =new accesorol();
                                DefaultTableModel tabla = new DefaultTableModel();
                                tabla = accr.leer();
                                for (int t=0;t<tabla.getRowCount();t++){
                                out.println("<tr data-id=" + tabla.getValueAt(t,0) +" data-id_a=" + tabla.getValueAt(t,3) + " data-id_r=" +tabla.getValueAt(t,4) + ">");
                                //out.println("<tr>");
                                out.println("<td>" + tabla.getValueAt(t,1) +"</td>");
                                out.println("<td>" + tabla.getValueAt(t,2) +"</td>");
//                              out.println("<td>" + tabla.getValueAt(t,4) +"</td>");
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
           
           $('#tbl_accesosrol').on('click','tr td',function(evt){
               var target,id,id_a,id_r;
               target = $(event.target);
               id = target.parent().data('id');
               id_a = target.parent().data('id_a');
               id_r = target.parent().data('id_r');    
               $("#txt_id").val(id);
               $("#Drop_acceso").val(id_a);
               $("#Drop_rol").val(id_r);
           });
       </script>    
    </body>
</html>
