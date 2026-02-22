
package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.Transferencia;
import proyectobancoplus.dtos.NuevoTransferenciaDTO;

/**
 *
 * @author maild
 */
public interface ITransferencias {
    
    public abstract Transferencia realizarTransferencia(NuevoTransferenciaDTO realizarTransferencia) throws NegocioException;    
}
