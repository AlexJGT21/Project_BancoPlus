/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectobancoplus.Persistencia;

import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Cesar Luna
 */

// contratos de activar cuenta y cancelar cuenta
public interface ICuentaDAO {
    
    //promesa de dar de alta la cuenta
    Cuenta agregarCuenta(Cuenta nuevaCuenta) throws PersistenciaException;    
  
    //lo mismo pero de baja
    void cancelarCuenta(Integer idCuenta) throws PersistenciaException;
}
