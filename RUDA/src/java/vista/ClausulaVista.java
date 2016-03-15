/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import logica.ClausulaLogicaLocal;
import modelo.Clausula;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Cristian®
 */
@ManagedBean (name = "ClausulaVista")
@RequestScoped
public class ClausulaVista {
    private InputText txtCodigoClausula;
    private InputText txtDescripcionClausula;
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private List<Clausula> listaClausula;
    private Clausula selectedClausula;
    

    public ClausulaVista(){
        
    }
    
    
    @EJB
    private ClausulaLogicaLocal clausulaLogica;
    public InputText getTxtCodigoClausula(){
        return txtCodigoClausula;
    }
    
    public void setTxtCodigoClausula(InputText txtCodigoClausula){
        this.txtCodigoClausula = txtCodigoClausula;
    }
    
    public InputText getTxtDescripcionClausula(){
        return txtDescripcionClausula;
    }
    
    public void setTxtDescripcionClausula(InputText txtDescripcionClausula){
        this.txtDescripcionClausula = txtDescripcionClausula;
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
    
    
    public List<Clausula> getListaClausula() {
        
        if(listaClausula==null)
        {
            try 
            {
                
                listaClausula = clausulaLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(ClausulaVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaClausula;
    }
    
    public void setListaPersonal(List<Clausula> listaClausula) {
        this.listaClausula = listaClausula;
    }

    public Clausula getSelectedClausula() {
        return selectedClausula;
    }

    public void setSelectedClausula(Clausula selectedClausula) {
        this.selectedClausula = selectedClausula;
    }

    public ClausulaLogicaLocal getPersonalLogica() {
        return clausulaLogica;
    }

    public void setPersonalLogica(ClausulaLogicaLocal clausulaLogica) {
        this.clausulaLogica = clausulaLogica;
    }
    
    public void cargarClausula(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel");

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copiarArchivo(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = clausulaLogica.importarDatosClausula(rutaDestino + "\\" + event.getFile().getFileName());
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
    
        

}
