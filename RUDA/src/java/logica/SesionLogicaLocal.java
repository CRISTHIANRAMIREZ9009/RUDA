
package logica;

import javax.ejb.Local;
import modelo.Funcionario;
import modelo.Instructor;
import modelo.Personal;

@Local
public interface SesionLogicaLocal {
    
    public Instructor iniciarSesionInstructor (Long documentopersonal, String clavepersonal) throws Exception;
    public Funcionario iniciarSesionFuncionario (Long documentopersonal, String clavepersonal) throws Exception;
    
}
