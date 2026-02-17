
package proyectobancoplus.dtos;

import proyectobancoplus.Entidades.Cliente;

/**
 *
 * @author AlexGarcía Trejo
 */
public class NuevoCuentaDTO {
    
    /**
     * Control del estado de cuentas de clientes.
     * 1. Activa: Esta en uso
     * 2. Cancelada: No puede realizar ninguna operación
     */
    enum EstadoCuenta {
        ACTIVA, CANCELADA
    }
    
    private Float saldoMXN;
    private EstadoCuenta estado; //ACTIVA, CANCELADA
    private Cliente idCliente;

    public NuevoCuentaDTO(Float saldoMXN, EstadoCuenta estado, Cliente idCliente) {
        this.saldoMXN = saldoMXN;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public Float getSaldoMXN() {
        return saldoMXN;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }
}