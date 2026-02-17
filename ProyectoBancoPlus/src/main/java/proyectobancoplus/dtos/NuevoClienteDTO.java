
package proyectobancoplus.dtos;

import java.util.GregorianCalendar;

/**
 *
 * @author Alex García Trejo
 */
public class NuevoClienteDTO {
    
    private String nombre;
    private String direccion;
    private String telefono;
    private GregorianCalendar fechaNacimiento;

    public NuevoClienteDTO(String nombre, String direccion, String telefono, GregorianCalendar fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }
}