
package proyectobancoplus.Negocio;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Persistencia.ICuentaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;
import proyectobancoplus.dtos.NuevoCuentaDTO;

/**
 *
 * @author Cesar Luna
 */
public class CuentaBO implements ICuentasBO {
    
    private final ICuentaDAO cuentaDAO;
    
    public CuentaBO(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    public Cuenta crearCuenta(NuevoCuentaDTO dto) throws NegocioException, PersistenciaException {
        if (dto.getSaldoMXN() < 0) {
            throw new NegocioException("El saldo inicial no puede ser negativo", null);
        }
        if (dto.getSaldoMXN() > 23437.00f) {
            throw new NegocioException("El saldo en la cuenta nueva no puede ser mas de $23,437 pesos", null);
        }
        
        // crear la cuenta y generar un nuevo codigo random
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setSaldoMXN(dto.getSaldoMXN());
        nuevaCuenta.setIdCliente(dto.getIdCliente());
        nuevaCuenta.setEstado(Cuenta.EstadoCuenta.ACTIVA);
        // la dao lo guarda en el sql
        return cuentaDAO.agregarCuenta(nuevaCuenta);
    }          

    @Override
    public List<Cuenta> obtenerCuentasActivas() throws NegocioException {
        try {
            return cuentaDAO.obtenerCuentasActivas();
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar cuentas de usuarios", e);
        }
    }
}
