
package proyectobancoplus.dtos;

import java.util.GregorianCalendar;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoRetiroSinCuentaDTO {
    
    private String folio;
    private String password;
    private Float monto;
    private GregorianCalendar fechaHoraRegistro;    //"yyyy-MM-dd HH:mm:ss"
    private Cuenta numCuenta; //IdCuenta

    public NuevoRetiroSinCuentaDTO() {
        
    }
    
    public NuevoRetiroSinCuentaDTO(String folio, String password, Float monto, GregorianCalendar fechaHoraRegistro, Cuenta numCuenta) {
        this.folio = folio;
        this.password = password;
        this.monto = monto;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.numCuenta = numCuenta;
    }

    public String getFolio() {
        return folio;
    }

    public String getPassword() {
        return password;
    }

    public Float getMonto() {
        return monto;
    }

    public GregorianCalendar getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }

    /**
     * NOTA DE AUTOR.
     * Preguntar al profesor si es correcto los setters en este caso
     */
    
    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public void setFechaHoraRegistro(GregorianCalendar fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public void setNumCuenta(Cuenta numCuenta) {
        this.numCuenta = numCuenta;
    }        
}