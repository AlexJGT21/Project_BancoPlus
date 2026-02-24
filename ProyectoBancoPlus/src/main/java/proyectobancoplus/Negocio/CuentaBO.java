
package proyectobancoplus.Negocio;

import java.util.List;
import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Negocio.NegocioException;
import proyectobancoplus.Persistencia.ICuentaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;
import proyectobancoplus.dtos.NuevoCuentaDTO;

/**
 *
 * @author Cesar Luna
 */


//clase cerebro
public class CuentaBO implements ICuentasBO {
//=======
//public class CuentaBO implements ICuentaDAO {
//>>>>>>> 2afb7461fa608908244a88e836c01186d384245f
//    private ICuentaDAO cuentaDAO;
//
//=======
//public class CuentaBO implements ICuentasBO {
//>>>>>>> 84f962041e3fd44ed3d2bf6f82c4e0d5ef05762c
//    
    private final ICuentaDAO cuentaDAO;
    
    public CuentaBO(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    public Cuenta crearCuenta(NuevoCuentaDTO dto) throws NegocioException, PersistenciaException {
        if (dto.getSaldoMXN() <= 0) {
            throw new NegocioException("El saldo inicial no puede ser negativo", null);
        }
        if (dto.getSaldoMXN() > 23437.00f) {
            throw new NegocioException("El saldo en la cuenta nueva no puede ser mas de $23,437 pesos", null);
        }
        
        // crear la cuenta
        Cuenta nuevaCuenta = new Cuenta();
        nuevaCuenta.setSaldoMXN(dto.getSaldoMXN());
        nuevaCuenta.setIdCliente(dto.getIdCliente());
        nuevaCuenta.setNumCuenta(dto.getNumCuenta());
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

        public void cancelarCuenta(Integer numCuenta ) throws NegocioException, PersistenciaException {
        if (numCuenta == null || numCuenta <= 0) {
            throw new NegocioException("Error bro", null);
        }
        cuentaDAO.cancelarCuenta(numCuenta);
    }








}





