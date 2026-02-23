
package proyectobancoplus.Negocio;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public interface ICuentasBO {
    
    //Contrato 1. Sirve para obtener cuentas activas y meter a un comboBox
    public abstract List<Cuenta> obtenerCuentasActivas() throws NegocioException;
}