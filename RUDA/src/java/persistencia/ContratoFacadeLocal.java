
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Contrato;

@Local
public interface ContratoFacadeLocal {

    void create(Contrato contrato);

    void edit(Contrato contrato);

    void remove(Contrato contrato);

    Contrato find(Object id);

    List<Contrato> findAll();

    List<Contrato> findRange(int[] range);

    int count();
    
}
