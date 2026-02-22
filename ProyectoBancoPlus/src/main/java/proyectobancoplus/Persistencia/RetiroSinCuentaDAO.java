
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.util.logging.Logger;
import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.dtos.NuevoRetiroSinCuentaDTO;

/**
 *
 * @author Alex García Trejo
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO {

    private static final Logger LOGGER = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    
    @Override
    public RetiroSinCuenta retiroSinCuenta(NuevoRetiroSinCuentaDTO retiroSinCuentaDTO) throws PersistenciaException {
        
        try {
            Connection connection = ConexionBD.crearConexion();
            
            
        } catch (Exception e) {
        }
    }
    
}
