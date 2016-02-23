
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Personal;

@Local
public interface PersonalLogicaLocal {
    
    void create (Personal personal) throws Exception;
    void edit (Personal personal) throws Exception;
    void remove (Personal personal) throws Exception;
    Personal find (Long documentopersonal) throws Exception;
    List<Personal> findAll() throws Exception;
    
}
