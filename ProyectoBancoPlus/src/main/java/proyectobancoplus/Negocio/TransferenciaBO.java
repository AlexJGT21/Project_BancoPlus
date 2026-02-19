package proyectobancoplus.Negocio;

import proyectobancoplus.Entidades.Transferencia;
import proyectobancoplus.Persistencia.ITransferenciaDAO;
import proyectobancoplus.Persistencia.PersistenciaException;
import proyectobancoplus.dtos.NuevoTransferenciaDTO;
import proyectobancoplus.Entidades.Cuenta;
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
        
        if (dto.getIdCuentaDestinatario() == null) {
            throw new NegocioException("Error: Tienes que seleccionar una cuenta para transferir", null);
        }
       if(dto.getMonto() < 0){
         throw new NegocioException("Error: el monto no puede ser negativo", null);
       }
       if (dto.getMonto() > 5000) {
        throw new NegocioException("Error: no puedes transferir mas de 5000 pesos", null);
        }
       
       
        
       //saco el numero de la cuenta, el id de la cuenta destino
       String numCuentaDestino = String.valueOf(dto.getIdCuentaDestinatario(). getIdCuenta());
       
        
        if (!numCuentaDestino.matches("\\d+")) {
        throw new NegocioException("Error: No puede haber letras en el numero de cuenta", null);
         }
    
        if (numCuentaDestino.length() < 8) {
        throw new NegocioException("Error: Numero incompleto", null);
        }
        
        if (dto.getIdCuentaRemitente().getSaldoMXN() < dto.getMonto()) {
        throw new NegocioException("Error: Fondos insuficientes", null);
        }
        
        
        //conecte con la DAO o puente despues de las validaciones
        
        try {

            return transferenciaDAO.realizarTransferencia(dto);
            
        } catch (PersistenciaException ex) {

            throw new NegocioException("No se armó", ex);
        }
        
        
        
//        try {
//            //este es el mapeo de la dto a la entidad
//            Transferencia nuevaTrans = new Transferencia();
//            nuevaTrans.setMonto(dto.getMonto());
//            
//            //creacion de los datos provisionales para la dao
//            //
//            nuevaTrans.setIdCuentaRemitente(dto.getIdCuentaRemitente());
//            nuevaTrans.setIdCuentaDestinatario(dto.getIdCuentaDestinatario());
//
//           // return transferenciaDAO.realizarTransferencia(nuevaTrans);
//
//        } catch (PersistenciaException ex) {
//
//            throw new NegocioException("Error en la transferencia: " + ex.getMessage());
//        }
       
    }
   }
