
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import logica.PersonalLogicaLocal;
import modelo.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.FileUploadEvent;

@ManagedBean (name = "funcionarioPersonalVista")
@RequestScoped
public class FuncionarioPersonalVista {
    
    private InputText txtDocumentoPersonal;
    private InputText txtNombrePersonal;
    private InputText txtApellidoPersonal;
    private InputText txtDireccionPersonal;
    private InputText txtCorreoPersonal;
    private InputText txtTelefonoPersonal;
    private InputText txtClavePersonal;
    private InputText txtFechaNacimientoPersonal;
    private InputText txtLugarNacimientoPersonal;
    private InputText txtFotoPersonal;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private List<Personal> listaPersonal;
    private Personal selectedPersonal;
    
    @EJB
    private PersonalLogicaLocal personalLogica;

    public FuncionarioPersonalVista() {
    }

    public InputText getTxtDocumentoPersonal() {
        return txtDocumentoPersonal;
    }

    public void setTxtDocumentoPersonal(InputText txtDocumentoPersonal) {
        this.txtDocumentoPersonal = txtDocumentoPersonal;
    }

    public InputText getTxtNombrePersonal() {
        return txtNombrePersonal;
    }

    public void setTxtNombrePersonal(InputText txtNombrePersonal) {
        this.txtNombrePersonal = txtNombrePersonal;
    }

    public InputText getTxtApellidoPersonal() {
        return txtApellidoPersonal;
    }

    public void setTxtApellidoPersonal(InputText txtApellidoPersonal) {
        this.txtApellidoPersonal = txtApellidoPersonal;
    }

    public InputText getTxtDireccionPersonal() {
        return txtDireccionPersonal;
    }

    public void setTxtDireccionPersonal(InputText txtDireccionPersonal) {
        this.txtDireccionPersonal = txtDireccionPersonal;
    }

    public InputText getTxtCorreoPersonal() {
        return txtCorreoPersonal;
    }

    public void setTxtCorreoPersonal(InputText txtCorreoPersonal) {
        this.txtCorreoPersonal = txtCorreoPersonal;
    }

    public InputText getTxtTelefonoPersonal() {
        return txtTelefonoPersonal;
    }

    public void setTxtTelefonoPersonal(InputText txtTelefonoPersonal) {
        this.txtTelefonoPersonal = txtTelefonoPersonal;
    }

    public InputText getTxtClavePersonal() {
        return txtClavePersonal;
    }

    public void setTxtClavePersonal(InputText txtClavePersonal) {
        this.txtClavePersonal = txtClavePersonal;
    }

    public InputText getTxtFechaNacimientoPersonal() {
        return txtFechaNacimientoPersonal;
    }

    public void setTxtFechaNacimientoPersonal(InputText txtFechaNacimientoPersonal) {
        this.txtFechaNacimientoPersonal = txtFechaNacimientoPersonal;
    }

    public InputText getTxtLugarNacimientoPersonal() {
        return txtLugarNacimientoPersonal;
    }

    public void setTxtLugarNacimientoPersonal(InputText txtLugarNacimientoPersonal) {
        this.txtLugarNacimientoPersonal = txtLugarNacimientoPersonal;
    }

    public InputText getTxtFotoPersonal() {
        return txtFotoPersonal;
    }

    public void setTxtFotoPersonal(InputText txtFotoPersonal) {
        this.txtFotoPersonal = txtFotoPersonal;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public List<Personal> getListaPersonal() {
        
        if(listaPersonal==null)
        {
            try 
            {
                
                listaPersonal = personalLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaPersonal;
    }

    public void setListaPersonal(List<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public Personal getSelectedPersonal() {
        return selectedPersonal;
    }

    public void setSelectedPersonal(Personal selectedPersonal) {
        this.selectedPersonal = selectedPersonal;
    }

    public PersonalLogicaLocal getPersonalLogica() {
        return personalLogica;
    }

    public void setPersonalLogica(PersonalLogicaLocal personalLogica) {
        this.personalLogica = personalLogica;
    }
    
    public void cargarPersonal(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel"); // Sustituye "/" por el directorio ej: "/upload"

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copyFile(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = docentelogica.importarDatosInstructor(rutaDestino + "\\" + event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok: ", resultado));
           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(DocenteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void copyFile(String rutaDestino, String fileName, InputStream in) {
        try {
            OutputStream out = new FileOutputStream(new File(rutaDestino + "\\" + fileName));
            System.out.println("Ruta Archivo: " + rutaDestino + "\\" +fileName);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            //System.out.println("New file created!");
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
    }
    
}
