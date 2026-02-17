
package proyectobancoplus.dtos;

import proyectobancoplus.Entidades.Cliente;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoTransferenciaDTO {
        
    private Float monto;
    private Cliente idCuentaRemitente; //Puede ser Integer, crear un objeto cliente y jalar la ID?
    private Cliente idCuentaDestinatario; //Lo mismo de arriba?

    public NuevoTransferenciaDTO(Float monto, Cliente idCuentaRemitente, Cliente idCuentaDestinatario) {
        this.monto = monto;
        this.idCuentaRemitente = idCuentaRemitente;
        this.idCuentaDestinatario = idCuentaDestinatario;
    }

    public Float getMonto() {
        return monto;
    }

    public Cliente getIdCuentaRemitente() {
        return idCuentaRemitente;
    }

    public Cliente getIdCuentaDestinatario() {
        return idCuentaDestinatario;
    }
}