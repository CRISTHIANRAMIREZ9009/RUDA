package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.xml.registry.infomodel.AuditableEvent;
import logica.ContratoLogicaLocal;
import modelo.Contrato;
import modelo.Instructor;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;


@ManagedBean (name = "instructorVista")
@RequestScoped
public class InstructorVista {

    
    private InputText txtCodigoRegional;
    private InputText txtCodigoCentro;
    private InputText txtFechaDiligenciamietoPlanilla;
    private InputText txtNombreContratista;
    private InputText txtApellidoContratista;
    private InputText txtDocumentoContratista;
    private InputText txtTelefonoContratista;
    private InputText txtCorreoContratista;
    private InputText txtCodigoDependencia;
    private InputText txtCodigoBanco;
    private InputText txtTipoCuentaContrato;
    private InputText txtNumeroCuentaContrato;
    private InputText txtClasePersona;
    private InputText txtIngresosSuperioresContrato;
    private InputText txtRegimenIvaContrato;
    private InputText txtExcluidoIvaContrato;
    private InputText txtDeclaranteContrato;
    private InputText txtPensionadoContrato;
    private InputText txtDependientesContratp;
    private InputText txtEmbargoContrato;
    private InputText txtValorEmbargoContrato;
    private InputText txtNumeroContrato;
    private InputText txtFechaInicioContrato;
    private InputText txtFechaFinContrato;
    private InputText txtValorTotalContrato;
    private InputText txtNumeroCompromisoSiifContrato;
    private InputText txtFormaPagoContrato;
    private InputText txtTipoARLContrato;
    
     private CommandButton btnReporte;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private CommandButton btnRegistrar;
    private List<Contrato> listaContratos;
    private Contrato selectedContrato;
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    private Object txtClaveContratista;
    public InstructorVista() {
    }

    public InputText getTxtCodigoRegional() {
        return txtCodigoRegional;
    }

    public void setTxtCodigoRegional(InputText txtCodigoRegional) {
        this.txtCodigoRegional = txtCodigoRegional;
    }

    public InputText getTxtCodigoCentro() {
        return txtCodigoCentro;
    }

    public void setTxtCodigoCentro(InputText txtCodigoCentro) {
        this.txtCodigoCentro = txtCodigoCentro;
    }

    public InputText getTxtFechaDiligenciamietoPlanilla() {
        return txtFechaDiligenciamietoPlanilla;
    }

    public void setTxtFechaDiligenciamietoPlanilla(InputText txtFechaDiligenciamietoPlanilla) {
        this.txtFechaDiligenciamietoPlanilla = txtFechaDiligenciamietoPlanilla;
    }

    public InputText getTxtNombreContratista() {
        return txtNombreContratista;
    }

    public void setTxtNombreContratista(InputText txtNombreContratista) {
        this.txtNombreContratista = txtNombreContratista;
    }

    public InputText getTxtApellidoContratista() {
        return txtApellidoContratista;
    }

    public void setTxtApellidoContratista(InputText txtApellidoContratista) {
        this.txtApellidoContratista = txtApellidoContratista;
    }
    

    public InputText getTxtDocumentoContratista() {
        return txtDocumentoContratista;
    }

    public void setTxtDocumentoContratista(InputText txtDocumentoContratista) {
        this.txtDocumentoContratista = txtDocumentoContratista;
    }

    public InputText getTxtTelefonoContratista() {
        return txtTelefonoContratista;
    }

    public void setTxtTelefonoContratista(InputText txtTelefonoContratista) {
        this.txtTelefonoContratista = txtTelefonoContratista;
    }

    public InputText getTxtCorreoContratista() {
        return txtCorreoContratista;
    }

    public void setTxtCorreoContratista(InputText txtCorreoContratista) {
        this.txtCorreoContratista = txtCorreoContratista;
    }

    public InputText getTxtCodigoDependencia() {
        return txtCodigoDependencia;
    }

    public void setTxtCodigoDependencia(InputText txtCodigoDependencia) {
        this.txtCodigoDependencia = txtCodigoDependencia;
    }

    public InputText getTxtCodigoBanco() {
        return txtCodigoBanco;
    }

    public void setTxtCodigoBanco(InputText txtCodigoBanco) {
        this.txtCodigoBanco = txtCodigoBanco;
    }

    public InputText getTxtTipoCuentaContrato() {
        return txtTipoCuentaContrato;
    }

    public void setTxtTipoCuentaContrato(InputText txtTipoCuentaContrato) {
        this.txtTipoCuentaContrato = txtTipoCuentaContrato;
    }

    public InputText getTxtNumeroCuentaContrato() {
        return txtNumeroCuentaContrato;
    }

    public void setTxtNumeroCuentaContrato(InputText txtNumeroCuentaContrato) {
        this.txtNumeroCuentaContrato = txtNumeroCuentaContrato;
    }

    public InputText getTxtClasePersona() {
        return txtClasePersona;
    }

    public void setTxtClasePersona(InputText txtClasePersona) {
        this.txtClasePersona = txtClasePersona;
    }

    public InputText getTxtIngresosSuperioresContrato() {
        return txtIngresosSuperioresContrato;
    }

    public void setTxtIngresosSuperioresContrato(InputText txtIngresosSuperioresContrato) {
        this.txtIngresosSuperioresContrato = txtIngresosSuperioresContrato;
    }

    public InputText getTxtRegimenIvaContrato() {
        return txtRegimenIvaContrato;
    }

    public void setTxtRegimenIvaContrato(InputText txtRegimenIvaContrato) {
        this.txtRegimenIvaContrato = txtRegimenIvaContrato;
    }

    public InputText getTxtExcluidoIvaContrato() {
        return txtExcluidoIvaContrato;
    }

    public void setTxtExcluidoIvaContrato(InputText txtExcluidoIvaContrato) {
        this.txtExcluidoIvaContrato = txtExcluidoIvaContrato;
    }

    public InputText getTxtDeclaranteContrato() {
        return txtDeclaranteContrato;
    }

    public void setTxtDeclaranteContrato(InputText txtDeclaranteContrato) {
        this.txtDeclaranteContrato = txtDeclaranteContrato;
    }

    public InputText getTxtPensionadoContrato() {
        return txtPensionadoContrato;
    }

    public void setTxtPensionadoContrato(InputText txtPensionadoContrato) {
        this.txtPensionadoContrato = txtPensionadoContrato;
    }

    public InputText getTxtDependientesContratp() {
        return txtDependientesContratp;
    }

    public void setTxtDependientesContratp(InputText txtDependientesContratp) {
        this.txtDependientesContratp = txtDependientesContratp;
    }

    public InputText getTxtEmbargoContrato() {
        return txtEmbargoContrato;
    }

    public void setTxtEmbargoContrato(InputText txtEmbargoContrato) {
        this.txtEmbargoContrato = txtEmbargoContrato;
    }

    public InputText getTxtValorEmbargoContrato() {
        return txtValorEmbargoContrato;
    }

    public void setTxtValorEmbargoContrato(InputText txtValorEmbargoContrato) {
        this.txtValorEmbargoContrato = txtValorEmbargoContrato;
    }

    public InputText getTxtNumeroContrato() {
        return txtNumeroContrato;
    }

    public void setTxtNumeroContrato(InputText txtNumeroContrato) {
        this.txtNumeroContrato = txtNumeroContrato;
    }

    public InputText getTxtFechaInicioContrato() {
        return txtFechaInicioContrato;
    }

    public void setTxtFechaInicioContrato(InputText txtFechaInicioContrato) {
        this.txtFechaInicioContrato = txtFechaInicioContrato;
    }

    public InputText getTxtFechaFinContrato() {
        return txtFechaFinContrato;
    }

    public void setTxtFechaFinContrato(InputText txtFechaFinContrato) {
        this.txtFechaFinContrato = txtFechaFinContrato;
    }

    public InputText getTxtValorTotalContrato() {
        return txtValorTotalContrato;
    }

    public void setTxtValorTotalContrato(InputText txtValorTotalContrato) {
        this.txtValorTotalContrato = txtValorTotalContrato;
    }

    public InputText getTxtNumeroCompromisoSiifContrato() {
        return txtNumeroCompromisoSiifContrato;
    }

    public void setTxtNumeroCompromisoSiifContrato(InputText txtNumeroCompromisoSiifContrato) {
        this.txtNumeroCompromisoSiifContrato = txtNumeroCompromisoSiifContrato;
    }

    public InputText getTxtFormaPagoContrato() {
        return txtFormaPagoContrato;
    }

    public void setTxtFormaPagoContrato(InputText txtFormaPagoContrato) {
        this.txtFormaPagoContrato = txtFormaPagoContrato;
    }

    public InputText getTxtTipoARLContrato() {
        return txtTipoARLContrato;
    }

    public void setTxtTipoARLContrato(InputText txtTipoARLContrato) {
        this.txtTipoARLContrato = txtTipoARLContrato;
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

    public List<Contrato> getListaContratos() {
        if(listaContratos==null)
        {
            try 
            {
                
                listaContratos = contratoLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(InstructorVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaContratos;
        
    }

    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    public ContratoLogicaLocal getContratoLogica() {
        return contratoLogica;
    }

    public void setContratoLogica(ContratoLogicaLocal contratoLogica) {
        this.contratoLogica = contratoLogica;
    }
    
      public void limpiar() {
        txtClasePersona.setValue("");
        txtEmbargoContrato.setValue("");
        txtDeclaranteContrato.setValue("");
        txtNumeroCompromisoSiifContrato.setValue("");
        txtExcluidoIvaContrato.setValue("");
        txtEmbargoContrato.setValue("");
        txtDependientesContratp.setValue("");
        txtFormaPagoContrato.setValue("");
        txtTipoARLContrato.setValue("");
        txtTipoCuentaContrato.setValue("");
        txtValorEmbargoContrato.setValue("");
        btnModificar.setDisabled(true);
        btnRegistrar.setDisabled(true);
        
    }
    public void accion_seleccionar(SelectEvent event){
        Contrato instructorSeleccionado=(Contrato)event.getObject();
        txtClasePersona.setValue(instructorSeleccionado.getClasepersonacontrato().toString());
        txtEmbargoContrato.setValue(instructorSeleccionado.getEmbargocontrato().toString());
        txtDeclaranteContrato.setValue(instructorSeleccionado.getDeclarantecontrato().toString());
        txtNumeroCompromisoSiifContrato.setValue(instructorSeleccionado.getNumerocompromisosiifcontrato().toString());
        txtExcluidoIvaContrato.setValue(instructorSeleccionado.getExcluidoivacontrato().toString());
        txtEmbargoContrato.setValue(instructorSeleccionado.getEmbargocontrato().toString());
        txtDependientesContratp.setValue(instructorSeleccionado.getDependientescontratp().toString());
        txtFormaPagoContrato.setValue(instructorSeleccionado.getFormapagocontrato().toString());
        txtTipoARLContrato.setValue(instructorSeleccionado.getTipoarlcontrato().toString());
        txtTipoCuentaContrato.setValue(instructorSeleccionado.getTipocuentacontrato().toString());
        txtValorEmbargoContrato.setValue(instructorSeleccionado.getValorembargocontrato().toString());
               
        
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnLimpiar.setDisabled(true);
    
    }
public void modificar(){
    try {
        Contrato nuevocontrato=new Contrato();
        
        nuevocontrato.setTipocuentacontrato(txtTipoCuentaContrato.getValue().toString());
        nuevocontrato.setIngresossuperiorescontrato(txtIngresosSuperioresContrato.getValue().toString());
        nuevocontrato.setExcluidoivacontrato(txtExcluidoIvaContrato.getValue().toString());
        nuevocontrato.setDeclarantecontrato(txtDeclaranteContrato.getValue().toString());
        nuevocontrato.setPensionadocontrato(txtPensionadoContrato.getValue().toString());
        nuevocontrato.setDependientescontratp(txtDependientesContratp.getValue().toString());
        nuevocontrato.setEmbargocontrato(txtEmbargoContrato.getValue().toString());
        nuevocontrato.setNumerocontrato(Integer.parseInt(txtNumeroContrato.getValue().toString()));
        String fechaI ="1990-02-20";
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        nuevocontrato.setFechainiciocontrato(formato.parse(fechaI));
        String fechaf ="1990-02-20";
        SimpleDateFormat formato1=new SimpleDateFormat("yyyy-MM-dd");
        nuevocontrato.setFechafincontrato(formato1.parse(fechaf));
        String fechaD ="1990-02-20";
        SimpleDateFormat formato2=new SimpleDateFormat("yyyy-MM-dd");
        
        
        nuevocontrato.setNumerocompromisosiifcontrato(Integer.parseInt(txtNumeroCompromisoSiifContrato.getValue().toString()));
        
        }catch (NumberFormatException ex) {
            String fechaI=txtFechaInicioContrato.toString();
             String fechaF=txtFechaFinContrato.toString();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El numero del documento debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Erro¡r", ex.getMessage()));
        }    
    
    }

    public void cargarContrato(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel");

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copiarArchivo(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = contratoLogica.importarDatosContrato(rutaDestino + "\\" + event.getFile().getFileName());
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