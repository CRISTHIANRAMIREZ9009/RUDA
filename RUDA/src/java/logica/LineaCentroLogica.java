
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Lineacentro;
import persistencia.LineacentroFacadeLocal;

@Stateless
public class LineaCentroLogica implements LineaCentroLogicaLocal {
    
    @EJB
    
    private LineacentroFacadeLocal lineacentroDAO;

    @Override
    public void create(Lineacentro lineacentro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Lineacentro lineacentro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Lineacentro lineacentro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lineacentro find(int codigolinea) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lineacentro> findAll() throws Exception {
        
        return lineacentroDAO.findAll();
        
    }

    
}
