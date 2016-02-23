
package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logica.SesionLogicaLocal;
import modelo.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

@ManagedBean (name = "sesionVista")
@RequestScoped
public class SesionVista {

    @EJB
    private SesionLogicaLocal sesionLogica;
    
    private InputText txtUsuario;
    private Password txtClave;
    private CommandButton btnIngresar;
    
    public SesionVista() {
    }

    public SesionLogicaLocal getSesionLogica() {
        return sesionLogica;
    }

    public void setSesionLogica(SesionLogicaLocal sesionLogica) {
        this.sesionLogica = sesionLogica;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void funcion_ingresar(){
        
        FacesContext context =FacesContext.getCurrentInstance();
        ExternalContext extContext=context.getExternalContext();
        String urlFuncionario=""; String urlInstructor="";
        
        try {
            
            urlInstructor = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/gestionFuncionario.xhtml"));
            urlFuncionario = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/gestionInstructor.xhtml"));
            Long documento = Long.parseLong(txtUsuario.getValue().toString());
            String clave = txtClave.getValue().toString();
            Personal instructorLogueado = sesionLogica.iniciarSesionInstructor(documento, clave);
            Personal funcionarioLogueado = null;
            
            if(instructorLogueado==null){
                funcionarioLogueado = sesionLogica.iniciarSesionFuncionario(documento, clave);
                if(funcionarioLogueado==null){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "!El usuario no existe¡"));
                }else{
                    //esta logueado un funcionario
                    extContext.getSessionMap().put("usuario", funcionarioLogueado);
                    extContext.getSessionMap().put("tipo", "funcionario");                    
                    extContext.redirect(urlFuncionario);
                }
            }else{
                //esta logueado un instructor
                extContext.getSessionMap().put("usuario", instructorLogueado);
                extContext.getSessionMap().put("tipo", "instructor");
                extContext.redirect(urlInstructor);
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","!Inicio de Sesion invalido¡"));
        }
        
    }
    
    public void cerrarSesion_action()
    {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext= context.getExternalContext();
            extContext.getSessionMap().remove("tipo");
            extContext.getSessionMap().remove("usuario");
            String url=extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/index.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
