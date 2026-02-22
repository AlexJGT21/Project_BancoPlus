
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
    private GregorianCalendar fechaHoraVencimiento;    //"yyyy-MM-dd HH:mm:ss"
    private Cuenta numCuenta; //IdCuenta

    public NuevoRetiroSinCuentaDTO(Integer folio, String password, Float monto, GregorianCalendar fechaHoraVencimiento, Cuenta numCuenta) {
        this.folio = folio;
        this.password = password;
        this.monto = monto;
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

    public GregorianCalendar getFechaHoraVencimiento() {
        return fechaHoraVencimiento;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }
}