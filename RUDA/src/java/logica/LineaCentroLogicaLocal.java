
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Lineacentro;

@Local
public interface LineaCentroLogicaLocal {
    
    void create (Lineacentro lineacentro) throws Exception;
    void edit (Lineacentro lineacentro) throws Exception;
    void remove (Lineacentro lineacentro) throws Exception;
    Lineacentro find (int codigolinea) throws Exception;
    List<Lineacentro> findAll() throws Exception;
    
}
