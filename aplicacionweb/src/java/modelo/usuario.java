package modelo;
import controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuario{
    private String usuario;
    private String nombre;
    private String password;
    private int nivel;
    conexion cn;
    public usuario (){}


    public usuario( int nivel,String usuario, String nombre, String password) {
        this.nivel = nivel;
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    public int agregar(){
        int retorno=0;
        try{
        PreparedStatement   Parametro;
        String query = "INSERT INTO usuario(nombre,usuario,clave,id_nivel) " + "values (?,?,?,?)";   
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getNombre());
        Parametro.setString(2, getUsuario());
        Parametro.setString(3, getPassword());
        Parametro.setInt(4, getNivel()); 
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }
        return retorno;
    }    
    
  public DefaultTableModel leer()
{
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn= new conexion();
        cn.abrirConexion();
        String query = "SELECT u.id_user as id ,u.nombre,u.usuario,clave, l.nombre AS rol ,l.role_id "+
                " FROM usuario AS u, role AS l "+ 
                "WHERE u.role_id = l.role_id";
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);   
        String encabezado []={"id","Nombre","Usuario","clave","rol","role_id"};
        tabla.setColumnIdentifiers(encabezado);
        
        String datos[] = new String[6];
        while (consulta.next()){
        datos[0]=consulta.getString("id");
        datos[1]=consulta.getString("nombre");
        datos[2]=consulta.getString("usuario");
        datos[3]=consulta.getString("clave");
        datos[4]=consulta.getString("rol");
        datos[5]=consulta.getString("role_id");
        tabla.addRow(datos);
    }
        
    }catch(Exception ex){
        System.out.println("Error..."+ ex.getMessage());
    }
        return tabla;
}

    
//    @Override
    public int actualizar(){
        int retorno =0;
        try{
            PreparedStatement   Parametro;
            String query = "UPDATE usuario SET nombre = ? , clave = ?   " + " WHERE usuario =?";    
            cn = new conexion();
            cn.abrirConexion();
            Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            Parametro.setString(1, getNombre());
            Parametro.setString(2, getPassword());
            Parametro.setString(3, getUsuario());  
            retorno=Parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;            
        }
        return retorno;
    }
    
//    @Override
    public int eliminar(){
        int retorno=0;
        try{
        PreparedStatement Parametro;
        String query = "DELETE FROM usuario " + " WHERE usuario = ?";
        cn = new conexion();
        cn.abrirConexion();
        Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
        Parametro.setString(1, getUsuario());
        retorno=Parametro.executeUpdate();
        cn.cerrarConexion();
        }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;
        }  
        return retorno;
    }
    /*@Override
    public int validar() {
        int retorno =0;
        int r = 0;
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        // password = md5(password);
        try{
            ResultSet rs;
            cn= new conexion();
            cn.abrirConexion();
            PreparedStatement sentencia = null; // sentencia sql
            //Parametro = (PreparedStatement) cn.conexionDB.prepareStatement(query);
            sentencia.setString(2, getUsuario());
            ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
            // retorno = sentencia.executeUpdate();
            while (sentencia.n ){
                r=r+1;
                sentencia.Set(consulta.get );
            if(r==1){
                return 1;
            }else{
                return 0;
            }
            }cn.cerrarConexion();
            }catch(Exception ex){
            System.out.println("Error..."+ex.getMessage());
            retorno=0;            
        }
        return retorno;
    } // validar
    */

}