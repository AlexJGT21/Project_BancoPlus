
package proyectobancoplus.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class CuentasDAO implements ICuentaDAO {

    private static final Logger LOGGER = Logger.getLogger(CuentasDAO.class.getName());
    private List<Cuenta> cuentasActivas;

    @Override
    public Cuenta agregarCuenta(Cuenta nuevaCuenta) throws PersistenciaException {
        
        String sql = "INSERT INTO cuentas (idCuenta, saldoMXN, estado, idCliente) VALUES (?, ?, 'ACTIVA', ?)";
        
        try (Connection conn = ConexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, nuevaCuenta.getNumCuenta());            
            ps.setFloat(2, nuevaCuenta.getSaldoMXN());
            ps.setInt(3, nuevaCuenta.getIdCliente().getIdCliente());
            
            ps.executeUpdate();
            
            return nuevaCuenta;
            
        } catch (SQLException e) {
            throw new PersistenciaException("Error al registrar al cliente en sql", null);
        }
    }
    
    @Override
    public void cancelarCuenta(Integer idCuenta) throws PersistenciaException {
        //logica del dar de bajar cuenta
        //codigo pa sql
        String sql = "UPDATE cuentas SET estado = 'CANCELADA' WHERE idCuenta = ?";
        
        try (Connection conn = ConexionBD.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idCuenta);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw new PersistenciaException("Error al cancelar la cuenta del cliente en sql", null);
        }
    }

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
