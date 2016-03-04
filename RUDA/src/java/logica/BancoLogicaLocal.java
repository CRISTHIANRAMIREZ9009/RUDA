
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Banco;

@Local
public interface BancoLogicaLocal {
    
    void create (Banco banco) throws Exception;
    void edit (Banco banco) throws Exception;
    void remove (Banco banco) throws Exception;
    Banco find (Integer codigobanco) throws Exception;
    List<Banco> findAll() throws Exception;
    
}
