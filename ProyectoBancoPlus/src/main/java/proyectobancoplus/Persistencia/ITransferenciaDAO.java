/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package proyectobancoplus.Persistencia;
/**
 *
 * @author Cesar Luna
 */
import java.util.List;
import proyectobancoplus.Entidades.Transferencia;

public interface ITransferenciaDAO {

//contrato 1 registrar transferencia
    public Transferencia realizarTransferencia(Transferencia transferencia) throws PersistenciaException;

// contrato 2 consultar los movimientos
    public List<Transferencia> consultarMovimientosCuenta(Integer idCuenta) throws PersistenciaException;
    
// contrato 3 consultar transferencias o filtrarlas por fechas
    public List<Transferencia> consultarTransferenciasPorFechas(Integer idCuenta, String fechaInicio, String fechaFin) throws PersistenciaException;
}