package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.Transferencia;
import proyectobancoplus.Persistencia.ITransferenciaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;
import proyectobancoplus.dtos.NuevoTransferenciaDTO;

/**
 *
 * @author Alex García Trejo
 */
public class TransferenciaBO implements IOperaciones {

//la interfaz q ya cree para guardar datos
    private ITransferenciaDAO transferenciaDAO;

    public TransferenciaBO(ITransferenciaDAO transferenciaDAO) {
        this.transferenciaDAO = transferenciaDAO;
    }

    @Override
    public Transferencia realizarTransferencia(NuevoTransferenciaDTO dto) throws NegocioException {

//validaciones
        if (dto.getMonto() <= 0) {
            throw new NegocioException("Error: el monto debe ser mayor a 0$", null);
        }
        if (dto.getIdCuentaRemitente().getIdCliente().equals(dto.getIdCuentaDestinatario().getIdCliente())) {
            throw new NegocioException("Error: no puedes transferir a la misma cuenta", null);
        }

        try {
            //este es el mapeo de la dto a la entidad
            Transferencia nuevaTrans = new Transferencia();
            nuevaTrans.setMonto(dto.getMonto());
            
            //creacion de los datos provisionales para la dao
            //
            nuevaTrans.setIdCuentaRemitente(dto.getIdCuentaRemitente());
            nuevaTrans.setIdCuentaDestinatario(dto.getIdCuentaDestinatario());

            return transferenciaDAO.realizarTransferencia(nuevaTrans);

        } catch (PersistenciaException e) {

            throw new NegocioException("Error en la transferencia: " + e.getMessage(), e);
        }
    }
}
