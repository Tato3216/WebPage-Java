package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

public class validar {
    private String usuario;
    private String password;
    public String nm;
    static String usr;
    static String frm;
    static String nmv;
    public String pass;
    public String lvl;
    conexion cn;
    static int rowcount;
//    request.setAttribute("itemList", avitems); 
//    ServletContext context= getServletContext();
//    RequestDispatcher rd= context.getRequestDispatcher("/principal.jsp");
//    rd.forward(request, response);
    
    public validar (){}
    
    public validar(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
        public boolean validar(){
        boolean userFound = false;
        try{
            PreparedStatement   Parametro;
            String query = "SELECT u.nombre, u.usuario, u.clave, a.frm, a.nombre AS nombre1 FROM usuario u"
                    + " INNER JOIN group_role gr ON gr.role_id = u.role_id INNER JOIN acces a On a.id_acces = gr.id_acces "
                    + " WHERE u.usuario = ? AND u.clave = ? ";
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setString(1, this.usuario);
            Parametro.setString(2, this.password);
            ResultSet rs = Parametro.executeQuery();
//            int rowcount = 0;
//            if (rs.last()) {
//                rowcount = rs.getRow();
//                rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
//                }
//                Menu [] menu = new Menu[rowcount];
//            String namewin [] = new String [rowcount];
//            String link [] = new String [rowcount];
            ArrayList<Menu> avitems = new ArrayList<Menu>();
            int count =0;
            while (rs.next()) {
                rowcount++;
//              String [] menu = new String[];
                usr = rs.getString("usuario");
                pass = rs.getString("clave");
                frm = rs.getString("frm");
                nmv = rs.getString("nombre1");
//                Menu item = new Menu(nmv, frm);
//                avitems.add(item);
                  Menu m = new Menu(rs.getString("nombre1"), rs.getString("frm"));
                 avitems.add(m);
//                 request.setAttribute("studentDetailsList", aList);
                if(this.usuario.compareTo(rs.getString("usuario")) == 0) {
                    if(this.password.compareTo(rs.getString("clave")) == 0) {
                        userFound = true;
//                for(int i=1; i<=rowcount;i++){
//                  namewin[count] = rs.getString("nombre1");
//                  link[count] = rs.getString("frm");
                  count++;
////                Menu m = new Menu(rs.getString("nombre1"), rs.getString("frm"));
//                }
//                menu[index]= m;
                    }
                }
//                request.setAttribute("itemList", m);
            }
            
            cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            //return "Execption " + usr + " - "+ex.getMessage();   
        }
        if(userFound) {
            return true;
        }
        return false ;
    } 
              
    public String getus(){
    return  this.usr;
}
   
    public String getfrm(){
    return  this.frm;
}
    
    public int getcont(){
    return  rowcount;
}
    
    public String getnmv(){
    return  this.nmv;
}
//    void static ArrayList<Menu> getList(){
//        return avitems;
//    }
    
}
