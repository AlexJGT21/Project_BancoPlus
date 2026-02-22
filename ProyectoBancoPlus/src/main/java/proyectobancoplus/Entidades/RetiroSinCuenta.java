
package proyectobancoplus.Entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author Alex García Trejo
 */
public class RetiroSinCuenta {
    
    //Uso del ENUM public para poder acceder a los valores
    public enum EstadoOperacion {
        POR_COBRAR, COBRADO, NO_COBRADO;
    }
    
    private Integer idRetiroSC;
    private Integer folio;
    private String password;
    private Float monto;
    private EstadoOperacion estadoOperacion;
    private GregorianCalendar fechaHoraRegistro; //"yyyy-MM-dd HH:mm:ss"
    private GregorianCalendar fechaHoraVencimiento;    //"yyyy-MM-dd HH:mm:ss"
    private Cuenta numCuenta;
    
    public RetiroSinCuenta() {
        //Vacio
    }

    public RetiroSinCuenta(Integer idRetiroSC, Integer folio, String password, Float monto, EstadoOperacion estadoOperacion, GregorianCalendar fechaHoraRegistro, GregorianCalendar fechaHoraVencimiento, Cuenta numCuenta) {
        this.idRetiroSC = idRetiroSC;
        this.folio = folio;
        this.password = password;
        this.monto = monto;
        this.estadoOperacion = estadoOperacion;
        this.fechaHoraRegistro = fechaHoraRegistro;
        this.fechaHoraVencimiento = fechaHoraVencimiento;
        this.numCuenta = numCuenta;
    }

    public Integer getIdRetiroSC() {
        return idRetiroSC;
    }

    public void setIdRetiroSC(Integer idRetiroSC) {
        this.idRetiroSC = idRetiroSC;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
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

    public EstadoOperacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(EstadoOperacion estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
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
