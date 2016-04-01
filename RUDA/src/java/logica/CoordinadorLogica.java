
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Coordinador;
import persistencia.CoordinadorFacadeLocal;

@Stateless
public class CoordinadorLogica implements CoordinadorLogicaLocal {
    
    @EJB
    
    private CoordinadorFacadeLocal coordinadorDAO;

    @Override
    public void create(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Coordinador coordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordinador find(Integer documentocoordinador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coordinador> findAll() throws Exception {
        
        return coordinadorDAO.findAll();
        
    }

    
    
}
