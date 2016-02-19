
package logica;

import javax.ejb.Local;
import modelo.Personal;

@Local
public interface SesionLogicaLocal {
    
    public Personal iniciarSesionInstructor (Long documentopersonal, String clavepersonal) throws Exception;
    public Personal iniciarSesionFuncionario (Long documentopersonal, String clavepersonal) throws Exception;
    
}
