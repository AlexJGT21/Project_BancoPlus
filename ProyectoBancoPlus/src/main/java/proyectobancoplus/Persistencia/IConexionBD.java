/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author melis
 */
public interface IConexionBD {
    //esta clase puede ser eliminada o implementada en conexionBD
    Connection crearConexion()throws SQLException;
}
