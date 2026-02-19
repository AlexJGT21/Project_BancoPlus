package proyectobancoplus;

import proyectobancoplus.Entidades.Cliente;
import proyectobancoplus.Presentacion.InicioSesionFORM;
import proyectobancoplus.Presentacion.TransferenciaForm;

/**
 *
 * @author Alex García Trejo
 */
public class ProyectoBancoPlus {

    public static void main(String[] args) {

        System.out.println("probando probando we");
        
        
    }
    public void iniciarBanca() {
        InicioSesionFORM llave = new InicioSesionFORM();
        llave.setVisible(true);
    }
    public void mostrarMenu(Cliente cliente){
    TransferenciaForm transferencia = new TransferenciaForm(this,transferenciaBO, cliente);
    transferencia.setVisible(true);
    }

   /*
    *metodos pendinetes 
    *mostraraLOgin->es el que muestra el inicio osea primer pantalla
    *mostrarTransferencia
    *ya en la main llaman a los metodos que contienen las pantallas
    *esto solo es del caso de uso de transferencia
    */ 

}
