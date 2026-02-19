
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex García Trejo
 */
public class ConexionBD implements IConexionBD{
    
    private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/bancoPlus";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "SQLLUCI"; //CONTRAÑA PERSONAL BD
    //NOTA DE AUTOR: NO DIFUNDIR
    //private static final String CONTRASENIA = "ITSON"; 
    //private static final String CONTRASENIA = ""; 
    
 
//    public static Connection crearConexion() throws SQLException{
//         Connection conexion = DriverManager.getConnection(
//            ConexionBD.CADENA_CONEXION, 
//            ConexionBD.USUARIO, 
//            ConexionBD.CONTRASENIA
//        );
//        return conexion;
//    }
   
    //solo es para ver si si conecta esto, es temporal

    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(CADENA_CONEXION,USUARIO,CONTRASENIA);

    }

   
    
}
