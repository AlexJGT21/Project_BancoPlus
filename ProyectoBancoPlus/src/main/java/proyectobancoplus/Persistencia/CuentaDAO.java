
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import proyectobancoplus.Entidades.Cuenta;

/**
 *
 * @author Alex García Trejo
 */
public class CuentaDAO implements ICuentaDAO {

    private static final Logger LOGGER = Logger.getLogger(CuentaDAO.class.getName());
    
    private List<Cuenta> cuentasActivas;
    
    @Override
    public List<Cuenta> obtenerCuentasActivas() throws PersistenciaException {
        cuentasActivas = new ArrayList<>();
        
        try {
            Connection connection = ConexionBD.crearConexion();
            
            String selectSQL = """
                               SELECT idCuenta, numCuenta, saldoMXN
                               FROM cuentas
                               WHERE estado = 'activa';
                               """;
            
            Statement querySQL = connection.createStatement();
            ResultSet result = querySQL.executeQuery(selectSQL);
            
            while (result.next()) {
                int idCuenta = result.getInt(1);
                int numCuenta = result.getInt(2);
                float saldoMXN = result.getFloat(3);
                cuentasActivas.add(new Cuenta(idCuenta, numCuenta, saldoMXN, null, null, null, null));                
            }
            return cuentasActivas;
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
            throw new PersistenciaException("No se pudo consultar cuentas", e);
        }
    }
}