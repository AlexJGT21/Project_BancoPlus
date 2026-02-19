
package proyectobancoplus.Entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author Alex García Trejo
 */
public class Transferencia {
    
    private Integer idTransferencia;
    private Float monto;
    private GregorianCalendar fechaHora;
    private Cuenta idCuentaRemitente; //Puede ser Integer, crear un objeto cliente y jalar la ID?
    private Cuenta idCuentaDestinatario; //Lo mismo de arriba?

    public Transferencia() {
    }

    public Transferencia(Integer idTransferencia, Float monto, GregorianCalendar fechaHora, Cuenta idCuentaRemitente, Cuenta idCuentaDestinatario) {
        this.idTransferencia = idTransferencia;
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.idCuentaRemitente = idCuentaRemitente;
        this.idCuentaDestinatario = idCuentaDestinatario;
    }

    public Integer getIdTransferencia() {
        return idTransferencia;
    }

    public void setIdTransferencia(Integer idTransferencia) {
        this.idTransferencia = idTransferencia;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Cuenta getIdCuentaRemitente() {
        return idCuentaRemitente;
    }

    public void setIdCuentaRemitente(Cuenta idCuentaRemitente) {
        this.idCuentaRemitente = idCuentaRemitente;
    }

    public Cuenta getIdCuentaDestinatario() {
        return idCuentaDestinatario;
    }

    public void setIdCuentaDestinatario(Cuenta idCuentaDestinatario) {
        this.idCuentaDestinatario = idCuentaDestinatario;
    }
}