
package proyectobancoplus.Negocio;

import java.util.GregorianCalendar;
import java.util.Random;
import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.Persistencia.IRetiroSinCuentaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;
import proyectobancoplus.dtos.NuevoRetiroSinCuentaDTO;

/**
 *
 * @author Alex García Trejo
 */
public class RetiroSinCuentaBO implements IRetiroSinCuentaBO {

    private IRetiroSinCuentaDAO retiroSinCuentaDAO;
    private static int ultimoFolio = 0;
    
    public RetiroSinCuentaBO(IRetiroSinCuentaDAO retiroSinCuentaDAO) {
        this.retiroSinCuentaDAO = retiroSinCuentaDAO;
    }

    @Override
    public RetiroSinCuenta generarRetiro(NuevoRetiroSinCuentaDTO retiroSinCuentaDTO) throws NegocioException {
        
        if (retiroSinCuentaDTO.getMonto() <= 0) {
            throw new NegocioException("El monto para realizar 'Retiro Sin Cuenta' no puede ser negativo", null);
        }
        if (retiroSinCuentaDTO.getMonto() > 5000) {
            throw new NegocioException("El monto para 'Retiro Sin Cuenta' no puede ser mayor a $5000.00", null);
        }
        
        String folio = generarFolio();
        String password = generarPassword();
        
        retiroSinCuentaDTO.setFolio(folio);
        retiroSinCuentaDTO.setPassword(password);
        
        GregorianCalendar ahora = new GregorianCalendar();
        GregorianCalendar vencimiento = new GregorianCalendar();
        vencimiento.add(GregorianCalendar.MINUTE, 10);
        
        retiroSinCuentaDTO.setFechaHoraRegistro(ahora);
        retiroSinCuentaDTO.setFechaHoraVencimiento(vencimiento);
        retiroSinCuentaDTO.setEstado(RetiroSinCuenta.EstadoOperacion.PENDIENTE);
        
        try {
            RetiroSinCuenta retiroSinCuenta = retiroSinCuentaDAO.retiroSinCuenta(retiroSinCuentaDTO);
            return retiroSinCuenta;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al generar folio y contraseña para 'Retiro Sin Cuenta'", null);
        }
    }
    
    private static String generarFolio() {
        ultimoFolio++;
        return String.format("F-%07d", ultimoFolio);
    }
    
    private static String generarPassword() {
        Random randomPassword = new Random();
        int passwordRandom = randomPassword.nextInt(90000000) + 10000000;
        return String.valueOf(passwordRandom);
    }
}