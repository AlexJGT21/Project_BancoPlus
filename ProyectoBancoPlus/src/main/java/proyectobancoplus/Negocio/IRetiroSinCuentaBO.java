
package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.dtos.NuevoRetiroSinCuentaDTO;

/**
 *
 * @author Alex García Trejo
 */
public interface IRetiroSinCuentaBO {
    
    public RetiroSinCuenta generarRetiro(NuevoRetiroSinCuentaDTO retiroSinCuentaDTO) throws NegocioException;
    
}
