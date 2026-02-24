
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
        Connection conn = null;
        try {
            conn = ConexionBD.crearConexion();
            conn.setAutoCommit(false); 

            String sqlRestar = "UPDATE cuentas SET saldoMXN = saldoMXN - ? WHERE numCuenta = ?";
            try (PreparedStatement psRestar = conn.prepareStatement(sqlRestar)) {
                psRestar.setFloat(1, nuevaTransferencia.getMonto());
                psRestar.setInt(2, nuevaTransferencia.getIdCuentaRemitente().getNumCuenta()); 
                int filasRestadas = psRestar.executeUpdate();
                if (filasRestadas == 0) {
                    throw new SQLException("La cuenta origen no existe");
                }
            }

            String sqlSumar = "UPDATE cuentas SET saldoMXN = saldoMXN + ? WHERE numCuenta = ?";
            try (PreparedStatement psSumar = conn.prepareStatement(sqlSumar)) {
                psSumar.setFloat(1, nuevaTransferencia.getMonto());
                psSumar.setInt(2, nuevaTransferencia.getIdCuentaDestinatario().getNumCuenta()); 
                int filasSumadas = psSumar.executeUpdate();
                if (filasSumadas == 0) {
                    throw new SQLException("La cuenta destino no existe");
                }
            }

            String sqlInsert = "INSERT INTO transferencias(monto, fechaHora, idCuentaRemitente, idCuentaDestinatario) VALUES (?, NOW(), ?, ?)";
            try (PreparedStatement psInsert = conn.prepareStatement(sqlInsert)) {
                psInsert.setFloat(1, nuevaTransferencia.getMonto());
                psInsert.setInt(2, nuevaTransferencia.getIdCuentaRemitente().getIdCuenta());
                psInsert.setInt(3, nuevaTransferencia.getIdCuentaDestinatario().getIdCuenta());
                psInsert.executeUpdate();
            }
            conn.commit(); 
            
            return new Transferencia(); 

        } catch (SQLException e) {
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
            e.printStackTrace();
            throw new PersistenciaException("No se pudo realizar la transferencia", e);
        } finally {
            if (conn != null) {
                try { conn.setAutoCommit(true); conn.close(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
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