
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import modelo.Funcionario;
import modelo.Instructor;
import modelo.Personal;
import persistencia.FuncionarioFacadeLocal;
import persistencia.InstructorFacadeLocal;
import persistencia.PersonalFacadeLocal;

@Stateless
public class SesionLogica implements SesionLogicaLocal {
    
    @EJB
    private InstructorFacadeLocal instructorDAO;
    
    @EJB
    private FuncionarioFacadeLocal funcionarioDAO;
    
    @EJB
    private PersonalFacadeLocal personalDAO;

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

    @Override
    public void cambiarContraseña(String usuario, String passwordOld, String passwordNew, String passwordNew2) throws Exception {
        
        if (passwordOld == null || passwordNew == null || passwordNew2 == null || passwordOld.equals("") || passwordNew.equals("") || passwordNew2.equals("")) {
            throw new Exception("!La Contraseña actual, la nueva y su confirmación son Obligatorias¡");
        }

        if (!passwordNew.equals(passwordNew2)) {
            throw new Exception("!La Contraseña nueva debe Coincidir con su confirmación¡");
        }

        //verifica si el coordinador con ese documento existe
        Personal entityPersonal = personalDAO.find(Long.parseLong(usuario));
        if (entityPersonal == null) {
           throw new Exception("!Usuario Incorrecto¡");
        }
        
        //si la contraseña no coincide
        if (!entityPersonal.getClavepersonal().equals(passwordOld)) {
            throw new Exception("!La Contraseña Otorgada No es Correcta para el Usuario¡");
        }      

        entityPersonal.setClavepersonal(passwordNew);
        //System.out.println("Datos "+personalNuevo.getClavepersonal());
        personalDAO.edit(entityPersonal);
        
    }

    @Override
    public boolean validarSesion() {
        
        String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        //System.out.println("usuario: " + user);
        //System.out.println("Tipo usuario: " + (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipoUsuario"));

        if (user == null) {
            return false;
        } else {
            return true;
        }
        
    }

}
