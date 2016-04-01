
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Coordinador;

@Local
public interface CoordinadorLogicaLocal {
    
    void create (Coordinador coordinador) throws Exception;
    void edit (Coordinador coordinador) throws Exception;
    void remove (Coordinador coordinador) throws Exception;
    Coordinador find (Integer documentocoordinador) throws Exception;
    List<Coordinador> findAll() throws Exception;
    
}
