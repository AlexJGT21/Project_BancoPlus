
package proyectobancoplus.dtos;

import java.util.GregorianCalendar;
import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Entidades.RetiroSinCuenta;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoRetiroSinCuentaDTO {
    
    private Integer folio;
    private String password;
    private Float monto;
    private RetiroSinCuenta.EstadoOperacion estadoOperacion;
    private GregorianCalendar fechaHoraRegistro; //"yyyy-MM-dd HH:mm:ss"
    private GregorianCalendar fechaHoraVencimiento;    //"yyyy-MM-dd HH:mm:ss"
    private Cuenta numCuenta;

    public NuevoRetiroSinCuentaDTO(Integer folio, String password, Float monto, RetiroSinCuenta.EstadoOperacion estadoOperacion, GregorianCalendar fechaHoraRegistro, GregorianCalendar fechaHoraVencimiento, Cuenta numCuenta) {
        this.folio = folio;
        this.password = password;
        this.monto = monto;
        this.estadoOperacion = estadoOperacion;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraVencimiento = fechaHoraVencimiento;
        this.numCuenta = numCuenta;
    }

    public Integer getFolio() {
        return folio;
    }

    public String getPassword() {
        return password;
    }

    public Float getMonto() {
        return monto;
    }

    public RetiroSinCuenta.EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public GregorianCalendar getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public GregorianCalendar getFechaHoraVencimiento() {
        return fechaHoraVencimiento;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }
}