
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import logica.PersonalLogicaLocal;
import modelo.Personal;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;

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
    private Calendar txtFechaNacimientoPersonal;
    private InputText txtLugarNacimientoPersonal;
    private InputText txtFotoPersonal;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnReporte;
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

    public Calendar getTxtFechaNacimientoPersonal() {
        return txtFechaNacimientoPersonal;
    }

    public void setTxtFechaNacimientoPersonal(Calendar txtFechaNacimientoPersonal) {
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

    public CommandButton getBtnReporte() {
        return btnReporte;
    }

    public void setBtnReporte(CommandButton btnReporte) {
        this.btnReporte = btnReporte;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    public void setListaPersonal(List<Personal> listaPersonal) {
        this.listaPersonal = listaPersonal;
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
    
    public void accion_registrar() {
        
        txtClavePersonal.setDisabled(true);

        try {
            Personal nuevaPersonal = new Personal();
            nuevaPersonal.setDocumentopersonal(Long.parseLong(txtDocumentoPersonal.getValue().toString()));
            nuevaPersonal.setNombrepersonal(txtNombrePersonal.getValue().toString());
            nuevaPersonal.setApellidopersonal(txtApellidoPersonal.getValue().toString());
            nuevaPersonal.setDireccionpersonal(txtDireccionPersonal.getValue().toString());
            nuevaPersonal.setCorreopersonal(txtCorreoPersonal.getValue().toString());
            nuevaPersonal.setTelefonopersonal(txtTelefonoPersonal.getValue().toString()); 
            nuevaPersonal.setClavepersonal(txtDocumentoPersonal.getValue().toString());
            String fecha = txtFechaNacimientoPersonal.getValue().toString();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            nuevaPersonal.setFechanacimientopersonal(formato.parse(fecha)); 
            nuevaPersonal.setLugarnacimientopersonal(txtLugarNacimientoPersonal.getValue().toString());
            nuevaPersonal.setFotopersonal(txtNombrePersonal.getValue().toString() + txtApellidoPersonal.getValue().toString());
            personalLogica.create(nuevaPersonal);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El personal se  registro correctamente¡"));
            listaPersonal = null;
        } catch (NumberFormatException ex1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El numero del documento debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡",ex.getMessage()));
        }
    }
    
    public void seleccionar(SelectEvent e){
        Personal personalSeleccionado = selectedPersonal;
        txtDocumentoPersonal.setValue(personalSeleccionado.getDocumentopersonal()+"");
        txtNombrePersonal.setValue(personalSeleccionado.getNombrepersonal());
        txtApellidoPersonal.setValue(personalSeleccionado.getApellidopersonal());
        txtDireccionPersonal.setValue(personalSeleccionado.getDireccionpersonal());
        txtCorreoPersonal.setValue(personalSeleccionado.getCorreopersonal());
        txtTelefonoPersonal.setValue(personalSeleccionado.getTelefonopersonal());
        txtClavePersonal.setValue(personalSeleccionado.getDocumentopersonal()+"");
        txtFechaNacimientoPersonal.setValue(personalSeleccionado.getFechanacimientopersonal());
        txtLugarNacimientoPersonal.setValue(personalSeleccionado.getLugarnacimientopersonal());
        btnModificar.setDisabled(false);
        btnRegistrar.setDisabled(true);
        btnLimpiar.setDisabled(true);
    }
    
    public void modificar(){
        try {
            Personal nuevaPersonal = new Personal();
            nuevaPersonal.setDocumentopersonal(Long.parseLong(txtDocumentoPersonal.getValue().toString()));
            nuevaPersonal.setNombrepersonal(txtNombrePersonal.getValue().toString());
            nuevaPersonal.setApellidopersonal(txtApellidoPersonal.getValue().toString());
            nuevaPersonal.setDireccionpersonal(txtDireccionPersonal.getValue().toString());
            nuevaPersonal.setCorreopersonal(txtCorreoPersonal.getValue().toString());
            nuevaPersonal.setTelefonopersonal(txtTelefonoPersonal.getValue().toString()); 
            nuevaPersonal.setClavepersonal(txtDocumentoPersonal.getValue().toString());
            String fecha = "1990-02-20";
            nuevaPersonal.setFechanacimientopersonal(Date.valueOf(fecha)); 
            nuevaPersonal.setLugarnacimientopersonal(txtLugarNacimientoPersonal.getValue().toString());
            nuevaPersonal.setFotopersonal(txtNombrePersonal.getValue().toString() + txtApellidoPersonal.getValue().toString());
            personalLogica.edit(nuevaPersonal);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El personal se modifico correctamente¡"));
            listaPersonal = null;
        } catch (NumberFormatException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El numero del documento debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Erro¡r", ex.getMessage()));
        }
    }
    
    public void limpiar() {
        txtDocumentoPersonal.setValue("");
        txtNombrePersonal.setValue("");
        txtApellidoPersonal.setValue("");
        txtDireccionPersonal.setValue("");
        txtCorreoPersonal.setValue("");
        txtTelefonoPersonal.setValue("");
        txtClavePersonal.setValue("");
        txtFechaNacimientoPersonal.setValue("");
        txtLugarNacimientoPersonal.setValue("");
    }
    
    public void cargarPersonal(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel");

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copiarArchivo(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = personalLogica.importarDatosPersonal(rutaDestino + "\\" + event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok: ", resultado));
           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioPersonalVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void copiarArchivo(String rutaDestino, String fileName, InputStream in) {
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
    
    public void generarReporte (){
        
        try {

                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                HttpServletRequest sr = ((HttpServletRequest) ec.getRequest());
                String scheme = sr.getScheme();
                String serverName = sr.getServerName();
                int port = sr.getServerPort();
                String contextPath = sr.getContextPath();
                String url = scheme + "://" + serverName + ":" + port + contextPath;
                System.out.println("Entro aqui reporte");
                personalLogica.generarReportePersonal(url);

            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        
    }  
    
}
