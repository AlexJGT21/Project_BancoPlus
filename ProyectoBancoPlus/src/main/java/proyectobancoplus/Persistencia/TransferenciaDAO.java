
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;
import proyectobancoplus.Entidades.Transferencia;
import proyectobancoplus.dtos.NuevoTransferenciaDTO;

/**
 *
 * @author Alex García Trejo
 */
public class TransferenciaDAO implements ITransferenciaDAO {

    private static final Logger LOGGER = Logger.getLogger(TransferenciaDAO.class.getName());    
    
    @Override
    public Transferencia realizarTransferencia(NuevoTransferenciaDTO nuevaTransferencia) throws PersistenciaException {
        
        try {
            
            //1.Primero conectarnos a la BD
            Connection connectionBD = ConexionBD.crearConexion();
            
            //2. Preparar la consulta para la BD
            String insertSQL = """
                               INSERT INTO transferencias(monto, fechaHora, idCuentaRemitente, idCuentaDestinatario)
                               VALUES (?, ?, ?, ?);
                               """;
            
            //3. Preparamos el statement
            PreparedStatement statement = connectionBD.prepareStatement(insertSQL);
            
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = newFormat.format(nuevaTransferencia.getFechaHora());
            //4.Reemplazo de parametros SQL por valores reales
            statement.setFloat(1, nuevaTransferencia.getMonto());
            statement.setString(2, dateTime);
            statement.setInt(3, nuevaTransferencia.getIdCuentaRemitente().getIdCuenta());
            statement.setInt(4, nuevaTransferencia.getIdCuentaDestinatario().getIdCuenta());
            
            //5. USAR EL EXECUTE() CORRESPONDIENTE
            //NOTA DE AUTOR: SIN EL EXECUTE() EL INSERT NO SE "EJECUTARA" VALGAME LA REDUNDANCIA
            //ES COMO ESTUDIAR PERO NO APRENDER, NO SIRVE DE NADA CREAR UN INSERT SI NO SE VA A INSERTAR EN ALGO(BD)
            boolean insert = statement.execute();
            
            //6. Se crea una nueva transferencia
            return new Transferencia(null, nuevaTransferencia.getMonto(), nuevaTransferencia.getFechaHora(),
                                        nuevaTransferencia.getIdCuentaRemitente(), 
                                        nuevaTransferencia.getIdCuentaDestinatario());
            
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("No se pudo realizar la transferencia", e);
        }
    }

    @Override
    public List<Transferencia> consultarMovimientosCuenta(Integer idCuenta) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transferencia> consultarTransferenciasPorFechas(Integer idCuenta, String fechaInicio, String fechaFin) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}