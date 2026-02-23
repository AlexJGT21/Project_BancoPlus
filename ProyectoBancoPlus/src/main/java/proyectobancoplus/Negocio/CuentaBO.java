
package proyectobancoplus.Negocio;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Persistencia.CuentaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;

/**
 *
 * @author Alex García Trejo
 */
public class CuentaBO implements ICuentasBO {

    @Override
    public List<Cuenta> obtenerCuentasActivas() throws NegocioException {
        
        CuentaDAO cuentaDAO = new CuentaDAO();
        try {
            return cuentaDAO.obtenerCuentasActivas();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener cuentas", ex);
        }                
    }
}