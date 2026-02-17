
package proyectobancoplus.Entidades;

/**
 *
 * @author Alex García Trejo
 */
public class Transferencia {
    
    private Integer idTransferencia;
    private Float monto;
    private Cliente idCuentaRemitente; //Puede ser Integer, crear un objeto cliente y jalar la ID?
    private Cliente idCuentaDestinatario; //Lo mismo de arriba?

    public Transferencia() {
    }

    public Transferencia(Integer idTransferencia, Float monto, Cliente idCuentaRemitente, Cliente idCuentaDestinatario) {
        this.idTransferencia = idTransferencia;
        this.monto = monto;
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

    public Cliente getIdCuentaRemitente() {
        return idCuentaRemitente;
    }

    public void setIdCuentaRemitente(Cliente idCuentaRemitente) {
        this.idCuentaRemitente = idCuentaRemitente;
    }

    public Cliente getIdCuentaDestinatario() {
        return idCuentaDestinatario;
    }

    public void setIdCuentaDestinatario(Cliente idCuentaDestinatario) {
        this.idCuentaDestinatario = idCuentaDestinatario;
    }
}