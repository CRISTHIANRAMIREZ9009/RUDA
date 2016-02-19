
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Contrato;
import persistencia.ContratoFacadeLocal;

@Stateless
public class ContratoLogica implements ContratoLogicaLocal {
    
    @EJB
    
    private ContratoFacadeLocal contratoDAO;

    @Override
    public void create(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            contratoDAO.create(contrato);
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato ya esta creado¡");
            
        }
        
    }

    @Override
    public void edit(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            throw new Exception ("!El contrato no exite y no se puede modificar¡");
            
        }
        
        else
        {
            
            contratoDAO.edit(contrato);
            
        }
        
    }

    @Override
    public void remove(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            throw new Exception ("!El contrato no exite y no se puede eliminar¡");
            
        }
        
        else
        {
            
            contratoDAO.remove(contrato);
            
        }
        
    }

    @Override
    public Contrato find(Integer numerocontrato) throws Exception {
        
        if(numerocontrato!=null)
        {
            
            return contratoDAO.find(numerocontrato);
            
        }
        
        else
        {
            
            throw new Exception ("!El numero de contrato es obligatorio para la busqueda¡");
            
        }
        
    }
    
    @Override
    public List<Contrato> findAll() throws Exception {
        return contratoDAO.findAll();
    }
   
}
