
package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Entidades.RetiroSinCuenta;

/**
 *
 * @author Alex García Trejo
 */
public interface IRetiroSinCuenta {
    
    public RetiroSinCuenta generarRetiro(float folio, Cuenta cuenta) throws NegocioException;
    
}
