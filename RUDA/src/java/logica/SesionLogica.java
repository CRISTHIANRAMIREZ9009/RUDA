
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Personal;
import persistencia.PersonalFacadeLocal;

@Stateless
public class SesionLogica implements SesionLogicaLocal {
    
    @EJB
    private PersonalFacadeLocal personalDAO;

    @Override
    public Personal iniciarSesionInstructor(Long documentopersonal, String clavepersonal) throws Exception {
    
        if(documentopersonal==null || clavepersonal==null)
        {
            
            throw new Exception ("!Los datos de ingreso son Obligatorios¡");
            
        }
        
        if (clavepersonal.equals(""))
        {
            
            throw new Exception ("!La clave es obligatoria¡");
            
        }
        
        Personal personal = personalDAO.find(documentopersonal);
        
        if(personal==null)
        {
            
            if(!personal.getClavepersonal().equals(clavepersonal))
            {
                
                throw new Exception ("!La clave es incorrecta¡");
                
            }
            
        }
        
        return personal;
    
    }

    @Override
    public Personal iniciarSesionFuncionario(Long documentopersonal, String clavepersonal) throws Exception {
        
        if(documentopersonal==null || clavepersonal==null)
        {
            
            throw new Exception ("!Los datos de ingreso son Obligatorios¡");
            
        }
        
        if (clavepersonal.equals(""))
        {
            
            throw new Exception ("!La clave es obligatoria¡");
            
        }
        
        Personal personal = personalDAO.find(documentopersonal);
        
        if(personal==null)
        {
            
            if(!personal.getClavepersonal().equals(clavepersonal))
            {
                
                throw new Exception ("!La clave es incorrecta¡");
                
            }
            
        }
        
        return personal;
        
    }

}
