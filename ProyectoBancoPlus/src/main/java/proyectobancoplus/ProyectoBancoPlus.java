
package proyectobancoplus;

import proyectobancoplus.Negocio.CuentaBO;
import proyectobancoplus.Negocio.ICuentasBO;
import proyectobancoplus.Persistencia.ICuentaDAO;
import proyectobancoplus.Persistencia.CuentasDAO;
import proyectobancoplus.Presentacion.BienvenidaFORM;
import proyectobancoplus.Presentacion.InicioSesionFORM;
import proyectobancoplus.Presentacion.MenuFORM;
import proyectobancoplus.Presentacion.RetiroSinCuentaFORM;
import proyectobancoplus.Presentacion.TransferenciaForm;
import proyectobancoplus.Presentacion.informacionTransferencia;

/**
 *
 * @author Alex García Trejo
 */
public class ProyectoBancoPlus {

    public static void main(String[] args) {

        System.out.println("Inciando bancaplus...");
        iniciarBanca();
       
        
    }
    public static void iniciarBanca() {
        BienvenidaFORM llave = new BienvenidaFORM();
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
    MenuFORM menu = new MenuFORM();
    menu.setVisible(true);
    
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
ICuentasBO cuentasBO = (ICuentasBO) new CuentaBO(cuentaDAO);
RetiroSinCuentaFORM rsc = new RetiroSinCuentaFORM(cuentasBO);
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
