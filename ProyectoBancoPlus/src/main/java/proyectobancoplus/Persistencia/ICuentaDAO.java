
package proyectobancoplus.Persistencia;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public interface ICuentaDAO {
    
    //Este se usa para consultas Cuentas Activas para llenar comboBox
    public List<Cuenta> obtenerCuentasActivas() throws PersistenciaException;
}
