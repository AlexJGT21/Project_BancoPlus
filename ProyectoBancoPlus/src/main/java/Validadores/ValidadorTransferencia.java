
package Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alex García Trejo
 */
public class ValidadorTransferencia {
    
    public boolean idCuentaDestinatario(String idCuentaDestinatario) {
        String regex = "^[A-ZÁ-Ýa-zá-ýÑñ ]{1,50}$";
        return validar(idCuentaDestinatario, regex);
    }        
    
    private static boolean validar(String texto, String reguex) {
        Pattern pattern = Pattern.compile(reguex); //Expresion regular
        Matcher matcher = pattern.matcher(texto); //Texto que queremos validar con la expresion regular
        return matcher.matches();
    }
}
