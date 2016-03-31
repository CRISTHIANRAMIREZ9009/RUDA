
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Banco;
import persistencia.BancoFacadeLocal;

@Stateless
public class BancoLogica implements BancoLogicaLocal {
    
    @EJB
    
    private BancoFacadeLocal bancoDAO;

    @Override
    public void create(Banco banco) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Banco banco) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Banco banco) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Banco find(Integer codigobanco) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Banco> findAll() throws Exception {
        
        return bancoDAO.findAll();
    }
    
}
