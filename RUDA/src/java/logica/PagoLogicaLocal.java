
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Pago;

@Local
public interface PagoLogicaLocal {
    
    void create (Pago pago) throws Exception;
    void edit (Pago pago) throws Exception;
    void remove (Pago pago) throws Exception;
    Pago find (int codigopago) throws Exception;
    List<Pago> findAll() throws Exception;
    public String importarDatosPago(String archivo) throws Exception;
    public void generarReportePago(String url) throws Exception;
    
}
