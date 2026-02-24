
package proyectobancoplus;

import proyectobancoplus.Negocio.CuentaBO;
import proyectobancoplus.Negocio.ICuentasBO;
import proyectobancoplus.Negocio.IRetiroSinCuentaBO;
import proyectobancoplus.Negocio.RetiroSinCuentaBO;
import proyectobancoplus.Persistencia.ICuentaDAO;
import proyectobancoplus.Persistencia.CuentasDAO;
import proyectobancoplus.Persistencia.IRetiroSinCuentaDAO;
import proyectobancoplus.Persistencia.RetiroSinCuentaDAO;
import proyectobancoplus.Presentacion.InicioSesionFORM;
import proyectobancoplus.Presentacion.RetiroSinCuentaFORM;
import proyectobancoplus.Presentacion.TransferenciaForm;
import proyectobancoplus.Presentacion.informacionTransferencia;

/**
 *
 * @author Alex García Trejo
 */
public class ProyectoBancoPlus {

    public static void main(String[] args) {

        System.out.println("Probando si jala xd");
        iniciarBanca();
       
        
    }
    public static void iniciarBanca() {
        InicioSesionFORM llave = new InicioSesionFORM();
        llave.setVisible(true);
    }

public static void mostrarInicioSesion(){
/**
 * Este metodo mostrara el form de inicio de sesion
 */
InicioSesionFORM login = new InicioSesionFORM();
        login.setVisible(true);
        login.setLocationRelativeTo(null);

}

public static void mostrarMenu(){
/**
 * Este metodo mostrara el menu de la banca
 */
//    MenuForm menu = new MenuForm();
//    menu.setVisible(true);
//    
}

public static void mostrarTransferencia(){
/**
 * Este metodo mostrara el form de transferencia
 */
    TransferenciaForm transferencia = new TransferenciaForm();
    transferencia.setVisible(true);
}

public static void mostrarRetiroSinCuenta(){
/**
 * Este metodo mostrara el form de retiro sin cuenta
 */
ICuentaDAO cuentaDAO = new CuentasDAO();
ICuentasBO cuentasBO = new CuentaBO(cuentaDAO);
IRetiroSinCuentaDAO retiroDAO = new RetiroSinCuentaDAO();
IRetiroSinCuentaBO retiroBO = new RetiroSinCuentaBO(retiroDAO);
RetiroSinCuentaFORM rsc = new RetiroSinCuentaFORM(cuentasBO, retiroBO);
rsc.setVisible(true);
}

public static void mostrarInformacionTransferencia(){
/**
 * Este metodo mostrara el form de informacion de la transferencia
 */
    informacionTransferencia infoT = new informacionTransferencia();
    infoT.setVisible(true);

}


}
