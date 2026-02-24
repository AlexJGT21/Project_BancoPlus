
package proyectobancoplus.Persistencia;

import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.dtos.NuevoRetiroSinCuentaDTO;

/**
 *
 * @author Alex García Trejo
 */
public interface IRetiroSinCuentaDAO {
    
    //Contrato 1: Retiro de dinero sin cuenta por parte de un tercero
    public RetiroSinCuenta retiroSinCuenta(NuevoRetiroSinCuentaDTO retiroSinCuenta) throws PersistenciaException;
    
    //Contrato 2: Busca el retiro sin cuenta generado y actualiza su estado a Cobrado/No_Cobrado
    public void actualizarEstadoRetiro(String folio, String contraseña) throws PersistenciaException;
}
