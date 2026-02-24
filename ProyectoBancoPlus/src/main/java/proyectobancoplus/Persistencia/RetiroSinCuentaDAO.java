
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import proyectobancoplus.Entidades.RetiroSinCuenta;
import proyectobancoplus.dtos.NuevoRetiroSinCuentaDTO;

/**
 *
 * @author Alex García Trejo
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO {

    private static final Logger LOGGER = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    
    @Override
    public RetiroSinCuenta retiroSinCuenta(NuevoRetiroSinCuentaDTO retiroSinCuenta) throws PersistenciaException {
        
        try {
            Connection connection = ConexionBD.crearConexion();
            
            String insertSQL = """
                               INSERT INTO retirosTerceros (folio, contrasenia, monto, fechaHoraRegistro, idCuenta)
                               VALUES
                               (?, ?, ?, ?, ?);
                               """;
            
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String vencimientoDate = newFormat.format(retiroSinCuenta.getFechaHoraRegistro().getTime());
            
            statement.setString(1, retiroSinCuenta.getFolio());
            statement.setString(2, retiroSinCuenta.getPassword());
            statement.setFloat(3, retiroSinCuenta.getMonto());
            statement.setString(4, vencimientoDate);
            statement.setInt(5, retiroSinCuenta.getNumCuenta().getIdCuenta());
            
            boolean insert = statement.execute();
            
            return new RetiroSinCuenta(null, retiroSinCuenta.getFolio(), retiroSinCuenta.getPassword(), retiroSinCuenta.getMonto(),
                                       null, null, retiroSinCuenta.getFechaHoraRegistro(),
                                       retiroSinCuenta.getNumCuenta());
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("Retiro sin Cuenta no fue posible", e);
        }
    }
}