
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
import modelo.Funcionario;
import modelo.Instructor;
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
    private Password passClaveVieja;
    private Password passClaveNueva;
    private Password passClaveNueva2;
    
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

    public Password getPassClaveVieja() {
        return passClaveVieja;
    }

    public void setPassClaveVieja(Password passClaveVieja) {
        this.passClaveVieja = passClaveVieja;
    }

    public Password getPassClaveNueva() {
        return passClaveNueva;
    }

    public void setPassClaveNueva(Password passClaveNueva) {
        this.passClaveNueva = passClaveNueva;
    }

    public Password getPassClaveNueva2() {
        return passClaveNueva2;
    }

    public void setPassClaveNueva2(Password passClaveNueva2) {
        this.passClaveNueva2 = passClaveNueva2;
    }
    
    public void funcion_ingresar(){
        
        FacesContext context =FacesContext.getCurrentInstance();
        ExternalContext extContext=context.getExternalContext();
        String urlFuncionario=""; String urlInstructor="";
        
        try {
            
            urlInstructor = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/faces/gestionInstructor.xhtml"));
            urlFuncionario = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/faces/gestionFuncionarioContrato.xhtml"));
            Long documento = Long.parseLong(txtUsuario.getValue().toString());
            String clave = txtClave.getValue().toString();
            Instructor instructorLogueado = sesionLogica.iniciarSesionInstructor(documento, clave);
            Funcionario funcionarioLogueado = null;
            
            if(instructorLogueado==null){
                funcionarioLogueado = sesionLogica.iniciarSesionFuncionario(documento, clave);
                if(funcionarioLogueado==null){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "!El usuario no existe¡"));
                }else{
                    //esta logueado un funcionario
                    System.out.println("Se loguea el funcionario? "+funcionarioLogueado.getPersonal().getNombrepersonal());
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
    
    public void cambiarPassword_action() {
        //System.out.println("Cambiar Pass");

        if (sesionLogica.validarSesion()) {
            try {
                String user = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
                String tipo = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("tipo");
                System.out.println("usuario: " + user + " tipo: " + tipo);

                sesionLogica.cambiarContraseña(user, passClaveVieja.getValue().toString(),
                        passClaveNueva.getValue().toString(), passClaveNueva2.getValue().toString());

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", "!La Contraseña Ha Sido Actualizada con Exito¡"));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡: ", ex.getMessage()));
            }

        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/SesionInvalida.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiarPassword_action() {
        //System.out.println("Limpiar Pass");

        passClaveNueva.setValue("");
        passClaveNueva2.setValue("");
        passClaveVieja.setValue("");

    }
    
}
