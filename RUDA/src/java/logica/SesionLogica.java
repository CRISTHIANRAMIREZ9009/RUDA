
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Funcionario;
import modelo.Instructor;
import persistencia.FuncionarioFacadeLocal;
import persistencia.InstructorFacadeLocal;

@Stateless
public class SesionLogica implements SesionLogicaLocal {
    
    @EJB
    private InstructorFacadeLocal instructorDAO;
    
    @EJB
    private FuncionarioFacadeLocal funcionarioDAO;

    @Override
    public Instructor iniciarSesionInstructor(Long documentopersonal, String clavepersonal) throws Exception {
    
        if(documentopersonal==null || clavepersonal==null)
        {
            
            throw new Exception ("!Los datos de ingreso son Obligatorios¡");
            
        }
        
        if (clavepersonal.equals(""))
        {
            
            throw new Exception ("!La clave es obligatoria¡");
            
        }
        
        Instructor instructor = instructorDAO.find(documentopersonal);
        
        if(instructor!=null)
        {
            
            if(!instructor.getPersonal().getClavepersonal().equals(clavepersonal))
            {
                
                throw new Exception ("!La clave es incorrecta¡");
                
            }
            
        }
        
        return instructor;
    
    }

    @Override
    public Funcionario iniciarSesionFuncionario(Long documentopersonal, String clavepersonal) throws Exception {
        
        if(documentopersonal==null || clavepersonal==null)
        {
            
            throw new Exception ("!Los datos de ingreso son Obligatorios¡");
            
        }
        
        if (clavepersonal.equals(""))
        {
            
            throw new Exception ("!La clave es obligatoria¡");
            
        }
        
        Funcionario funcionario = funcionarioDAO.find(documentopersonal);
        
        if(funcionario!=null)
        {
            
            if(!funcionario.getPersonal().getClavepersonal().equals(clavepersonal))
            {
                
                throw new Exception ("!La clave es incorrecta¡");
                
            }
            
        }
        
        return funcionario;
        
    }

}
