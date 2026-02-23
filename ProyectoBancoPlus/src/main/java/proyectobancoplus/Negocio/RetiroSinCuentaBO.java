
package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.Persistencia.IRetiroSinCuentaDAO;

/**
 *
 * @author Alex García Trejo
 */
public class RetiroSinCuentaBO implements IRetiroSinCuenta {

    private final IRetiroSinCuentaDAO retiroSinCuentaDAO;
    
    public RetiroSinCuentaBO(IRetiroSinCuentaDAO retiroSinCuentaDAO) {
        this.retiroSinCuentaDAO = retiroSinCuentaDAO;
    }
    
    @Override
    public RetiroSinCuenta generarRetiro(float folio, Cuenta cuenta) throws NegocioException {
        
        
        return null;
        
        
    }
    
}
