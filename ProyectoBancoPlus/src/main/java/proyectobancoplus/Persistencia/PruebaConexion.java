/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    
    
    public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos MySQL");

        try {
            Connection conexion = ConexionBD.crearConexion();

            if (conexion != null) {
                System.out.println("EXITO Conexión establecida correctamente a bancoplus");
                System.out.println("Ya puedes cerrar esta prueba y seguir con tu proyecto");
                
                conexion.close();
            }

        } catch (SQLException e) {
            System.out.println("ERROR FATAL: No se pudo conectar a la base de datos");
            System.out.println("--------------------------------------------------");
            System.out.println("Fíjate en el texto rojo de abajo para saber por qué fallo");
            e.printStackTrace(); 
        }
    }
}