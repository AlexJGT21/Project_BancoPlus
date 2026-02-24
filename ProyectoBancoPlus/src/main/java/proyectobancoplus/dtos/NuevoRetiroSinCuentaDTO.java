
package proyectobancoplus.dtos;

import java.util.GregorianCalendar;
import proyectobancoplus.Entidades.Cuenta;
import proyectobancoplus.Entidades.RetiroSinCuenta.EstadoOperacion;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoRetiroSinCuentaDTO {
    
    private String folio;
    private String password;
    private Float monto;
    private EstadoOperacion estado;
    private GregorianCalendar fechaHoraRegistro;    //"yyyy-MM-dd HH:mm:ss"
    private GregorianCalendar fechaHoraVencimiento;
    private Cuenta numCuenta; //IdCuenta

    public NuevoRetiroSinCuentaDTO() {        
    }

    public NuevoRetiroSinCuentaDTO(String folio, String password, Float monto, EstadoOperacion estado, GregorianCalendar fechaHoraRegistro, GregorianCalendar fechaHoraVencimiento, Cuenta numCuenta) {
        this.folio = folio;
        this.password = password;
        this.monto = monto;
        this.estado = estado;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraVencimiento = fechaHoraVencimiento;
        this.numCuenta = numCuenta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public EstadoOperacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoOperacion estado) {
        this.estado = estado;
    }

    public GregorianCalendar getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(GregorianCalendar fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public GregorianCalendar getFechaHoraVencimiento() {
        return fechaHoraVencimiento;
    }

    public void setFechaHoraVencimiento(GregorianCalendar fechaHoraVencimiento) {
        this.fechaHoraVencimiento = fechaHoraVencimiento;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Cuenta numCuenta) {
        this.numCuenta = numCuenta;
    }
}