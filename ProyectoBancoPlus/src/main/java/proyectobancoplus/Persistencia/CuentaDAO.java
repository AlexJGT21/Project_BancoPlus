/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Cesar Luna
 */
public class CuentaDAO implements ICuentaDAO {
    @Override
    public Cuenta agregarCuenta(Cuenta nuevaCuenta) throws PersistenciaException {
        //aqui se genera el codigo random de 8 digitos
        int numeroCuentaGenerado = (int) (Math.random() * 90000000) + 10000000;
        
        String sql = "INSERT INTO cuentas (idCuenta, saldoMXN, estado, idCliente) VALUES (?, ?, 'ACTIVA', ?)";
        
        try (Connection conn = ConexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, numeroCuentaGenerado);
            ps.setFloat(2, nuevaCuenta.getSaldoMXN());
            ps.setInt(3, nuevaCuenta.getIdCliente().getIdCliente());
            
            ps.executeUpdate();
            
            nuevaCuenta.setIdCuenta(numeroCuentaGenerado);
            return nuevaCuenta;
            
        } catch (SQLException e) {
            throw new PersistenciaException("Error al registrar al cliente en sql", null);
        }
    }
    
    @Override
    public void cancelarCuenta(Integer idCuenta) throws PersistenciaException {

//logica del dar de bajar cuenta
        //codigo pa sql
        String sql = "UPDATE cuentas SET estado = 'CANCELADA' WHERE idCuenta = ?";
        
        try (Connection conn = ConexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idCuenta);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new PersistenciaException("Error al cancelar la cuenta del cliente en sql", null);
        }
    }
    
    
    
    
    
    
}
