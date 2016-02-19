
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Contrato;

@Local
public interface ContratoLogicaLocal {
    
    void create (Contrato contrato) throws Exception;
    void edit (Contrato contrato) throws Exception;
    void remove (Contrato contrato) throws Exception;
    Contrato find (Integer numerocontrato) throws Exception;
    List<Contrato> findAll() throws Exception;
    
}
