
package proyectobancoplus.dtos;

import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoTransferenciaDTO {
        
    private Float monto;
    private Cuenta idCuentaRemitente; //Puede ser Integer, crear un objeto cliente y jalar la ID?
    private Cuenta idCuentaDestinatario; //Lo mismo de arriba?

    public NuevoTransferenciaDTO(Float monto, Cuenta idCuentaRemitente, Cuenta idCuentaDestinatario) {
        this.monto = monto;
        this.idCuentaRemitente = idCuentaRemitente;
        this.idCuentaDestinatario = idCuentaDestinatario;
    }

    public Float getMonto() {
        return monto;
    }

    public Cuenta getIdCuentaRemitente() {
        return idCuentaRemitente;
    }

    public Cuenta getIdCuentaDestinatario() {
        return idCuentaDestinatario;
    }
}