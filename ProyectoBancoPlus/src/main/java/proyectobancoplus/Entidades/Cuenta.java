
package proyectobancoplus.Entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author Alex García Trejo
 */
public class Cuenta {
    
    /**
     * Control del estado de cuentas de clientes.
     * 1. Activa: Esta en uso
     * 2. Cancelada: No puede realizar ninguna operación
     */
    enum EstadoCuenta {
        ACTIVA, CANCELADA
    }
    
    private Integer idCuenta;
    private Float saldoMXN;
    private EstadoCuenta estado; //ACTIVA, CANCELADA
    private GregorianCalendar fechaApertura;
    private Cliente idCliente;
    private String contraseña;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta, Float saldoMXN, EstadoCuenta estado, GregorianCalendar fechaApertura, Cliente idCliente, String contraseña) {
        this.idCuenta = idCuenta;
        this.saldoMXN = saldoMXN;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.idCliente = idCliente;
        this.contraseña = contraseña;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Float getSaldoMXN() {
        return saldoMXN;
    }

    public void setSaldoMXN(Float saldoMXN) {
        this.saldoMXN = saldoMXN;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(GregorianCalendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}