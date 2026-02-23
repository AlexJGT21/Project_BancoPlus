
package proyectobancoplus.Persistencia;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public interface ICuentaDAO {
    
    //promesa de dar de alta la cuenta
    Cuenta agregarCuenta(Cuenta nuevaCuenta) throws PersistenciaException;    
  
    //lo mismo pero de baja
    void cancelarCuenta(Integer idCuenta) throws PersistenciaException;

    public List<Cuenta> obtenerCuentasActivas() throws PersistenciaException;
}
