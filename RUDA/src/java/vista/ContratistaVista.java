package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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
import javax.xml.registry.infomodel.AuditableEvent;
import logica.ContratoLogicaLocal;
import logica.PagoLogicaLocal;
import modelo.Contrato;
import modelo.Pago;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;


@ManagedBean (name = "ContratistaVista")
@RequestScoped
public class ContratistaVista {

    
    private InputText txtCodigopago;
    private InputText txtNumeroPago;
    private Date txtFechaInicioPago;
    private Date txtFechaFinPago;
    private InputText txtSaldoAnteriorPago;
    private InputText txtSaldoNuevoPago;
    private InputText txtNumeroContratoPago;
    private InputText txtNumeroHorasPago;
    private InputText txtDiasLiquidacionPago;
    private InputText txtNumeroPlanillaPago;
    private InputText txtIbcPago;
    private InputText txtAportesSaludPago;
    private InputText txtAportePensionadoPago;
    private InputText txtAporteSolidarioPago;
    private InputText txtAporteArl;
    private InputText txtAhorroVoluntarioPago;
    private InputText txtDependientesPago;
    private InputText txtSaludPrepagadaPago;
    private InputText txtInteresViviendaPago;
    
    private CommandButton btnReporte;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private CommandButton btnRegistrar;
    private CommandButton btnEliminar;
    private List<Pago> listaPago;
    private Pago selectedPago;
    private List<Contrato> listaContrato;
    private Contrato selectedContrato;            
    
    @EJB
    private PagoLogicaLocal pagoLogica;
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    
    public ContratistaVista() {
    }

    public InputText getTxtCodigopago() {
        return txtCodigopago;
    }

    public void setTxtCodigopago(InputText txtCodigopago) {
        this.txtCodigopago = txtCodigopago;
    }

    public InputText getTxtNumeroPago() {
        return txtNumeroPago;
    }

    public void setTxtNumeroPago(InputText txtNumeroPago) {
        this.txtNumeroPago = txtNumeroPago;
    }

    public Date getTxtFechaInicioPago() {
        return txtFechaInicioPago;
    }

    public void setTxtFechaInicioPago(Date txtFechaInicioPago) {
        this.txtFechaInicioPago = txtFechaInicioPago;
    }

    public Date getTxtFechaFinPago() {
        return txtFechaFinPago;
    }

    public void setTxtFechaFinPago(Date txtFechaFinPago) {
        this.txtFechaFinPago = txtFechaFinPago;
    }

    public InputText getTxtSaldoAnteriorPago() {
        return txtSaldoAnteriorPago;
    }

    public void setTxtSaldoAnteriorPago(InputText txtSaldoAnteriorPago) {
        this.txtSaldoAnteriorPago = txtSaldoAnteriorPago;
    }

    public InputText getTxtSaldoNuevoPago() {
        return txtSaldoNuevoPago;
    }

    public void setTxtSaldoNuevoPago(InputText txtSaldoNuevoPago) {
        this.txtSaldoNuevoPago = txtSaldoNuevoPago;
    }

    public InputText getTxtNumeroContratoPago() {
        return txtNumeroContratoPago;
    }

    public void setTxtNumeroContratoPago(InputText txtNumeroContratoPago) {
        this.txtNumeroContratoPago = txtNumeroContratoPago;
    }

    public InputText getTxtNumeroHorasPago() {
        return txtNumeroHorasPago;
    }

    public void setTxtNumeroHorasPago(InputText txtNumeroHorasPago) {
        this.txtNumeroHorasPago = txtNumeroHorasPago;
    }

    public InputText getTxtDiasLiquidacionPago() {
        return txtDiasLiquidacionPago;
    }

    public void setTxtDiasLiquidacionPago(InputText txtDiasLiquidacionPago) {
        this.txtDiasLiquidacionPago = txtDiasLiquidacionPago;
    }

    public InputText getTxtNumeroPlanillaPago() {
        return txtNumeroPlanillaPago;
    }

    public void setTxtNumeroPlanillaPago(InputText txtNumeroPlanillaPago) {
        this.txtNumeroPlanillaPago = txtNumeroPlanillaPago;
    }

    public InputText getTxtIbcPago() {
        return txtIbcPago;
    }

    public void setTxtIbcPago(InputText txtIbcPago) {
        this.txtIbcPago = txtIbcPago;
    }

    public InputText getTxtAportesSaludPago() {
        return txtAportesSaludPago;
    }

    public void setTxtAportesSaludPago(InputText txtAportesSaludPago) {
        this.txtAportesSaludPago = txtAportesSaludPago;
    }

    public InputText getTxtAportePensionadoPago() {
        return txtAportePensionadoPago;
    }

    public void setTxtAportePensionadoPago(InputText txtAportePensionadoPago) {
        this.txtAportePensionadoPago = txtAportePensionadoPago;
    }

    public InputText getTxtAporteSolidarioPago() {
        return txtAporteSolidarioPago;
    }

    public void setTxtAporteSolidarioPago(InputText txtAporteSolidarioPago) {
        this.txtAporteSolidarioPago = txtAporteSolidarioPago;
    }

    public InputText getTxtAporteArl() {
        return txtAporteArl;
    }

    public void setTxtAporteArl(InputText txtAporteArl) {
        this.txtAporteArl = txtAporteArl;
    }

    public InputText getTxtAhorroVoluntarioPago() {
        return txtAhorroVoluntarioPago;
    }

    public void setTxtAhorroVoluntarioPago(InputText txtAhorroVoluntarioPago) {
        this.txtAhorroVoluntarioPago = txtAhorroVoluntarioPago;
    }

    public InputText getTxtDependientesPago() {
        return txtDependientesPago;
    }

    public void setTxtDependientesPago(InputText txtDependientesPago) {
        this.txtDependientesPago = txtDependientesPago;
    }

    public InputText getTxtSaludPrepagadaPago() {
        return txtSaludPrepagadaPago;
    }

    public void setTxtSaludPrepagadaPago(InputText txtSaludPrepagadaPago) {
        this.txtSaludPrepagadaPago = txtSaludPrepagadaPago;
    }

    public InputText getTxtInteresViviendaPago() {
        return txtInteresViviendaPago;
    }

    public void setTxtInteresViviendaPago(InputText txtInteresViviendaPago) {
        this.txtInteresViviendaPago = txtInteresViviendaPago;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public ContratoLogicaLocal getContratoLogica() {
        return contratoLogica;
    }

    public void setContratoLogica(ContratoLogicaLocal contratoLogica) {
        this.contratoLogica = contratoLogica;
    }

    public List<Pago> getListaPago() {
        if(listaPago==null)
        {
            try 
            {
                
                listaPago = pagoLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaPago;
    }

    public List<Contrato> getListaContrato() {
        if(listaContrato==null)
        {
            try 
            {
                
                listaContrato = contratoLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        return listaContrato;
    }

    public void setListaContrato(List<Contrato> listaContrato) {
        this.listaContrato = listaContrato;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    public void setListaPago(List<Pago> listaPago) {
        this.listaPago = listaPago;
    }
    
    public Pago getSelectedPago() {
        return selectedPago;
    }

    public void setSelectedPago(Pago selectedPago) {
        this.selectedPago = selectedPago;
    }

    public PagoLogicaLocal getPagoLogica() {
        return pagoLogica;
    }

    public void setPagoLogica(PagoLogicaLocal pagoLogica) {
        this.pagoLogica = pagoLogica;
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
        
    public void limpiar() {
        txtCodigopago.setValue("");
        txtNumeroPago.setValue("");
        txtFechaInicioPago.setDate(0);
        txtFechaFinPago.setDate(0);
        txtSaldoAnteriorPago.setValue("");
        txtSaldoNuevoPago.setValue("");
        txtNumeroContratoPago.setValue("");
        txtNumeroHorasPago.setValue("");
        txtDiasLiquidacionPago.setValue("");
        txtNumeroPlanillaPago.setValue("");
        txtIbcPago.setValue("");
        txtAportesSaludPago.setValue("");
        txtAportePensionadoPago.setValue("");
        txtAporteSolidarioPago.setValue("");
        txtAporteArl.setValue("");
        txtAhorroVoluntarioPago.setValue("");
        txtDependientesPago.setValue("");
        txtSaludPrepagadaPago.setValue("");
        txtInteresViviendaPago.setValue("");
        btnModificar.setDisabled(true);
        btnRegistrar.setDisabled(true);

    }
    
    public void accion_registrar() {
        try {
            Pago nuevoPago = new Pago();
            Contrato nuevoContrato = new Contrato();
            nuevoPago.setCodigopago(Integer.parseInt(txtCodigopago.getValue().toString()));
            nuevoPago.setNumeropago(Integer.parseInt(txtNumeroPago.getValue().toString()));
            nuevoPago.setFechainiciopago(txtFechaInicioPago);
            nuevoPago.setFechafinpago(txtFechaFinPago);
            nuevoPago.setSaldoanteriorpago(Integer.parseInt(txtSaldoAnteriorPago.getValue().toString()));
            nuevoPago.setSaldonuevopago(Integer.parseInt(txtSaldoNuevoPago.getValue().toString()));
            nuevoContrato.setNumerocontrato(Integer.parseInt(txtNumeroContratoPago.getValue().toString()));
            nuevoPago.setNumerocontratopago(nuevoContrato);
            nuevoPago.setNumerohoraspago(Integer.parseInt(txtNumeroHorasPago.getValue().toString()));
            nuevoPago.setDiasliquidarpago(Integer.parseInt(txtDiasLiquidacionPago.getValue().toString()));
            nuevoPago.setNumeroplanillapago(Integer.parseInt(txtNumeroPlanillaPago.getValue().toString())); 
            nuevoPago.setIbcpago(Integer.parseInt(txtIbcPago.getValue().toString()));            
            nuevoPago.setAportessaludpago(Integer.parseInt(txtAportesSaludPago.getValue().toString()));
            nuevoPago.setAportepensionpago(Integer.parseInt(txtAportePensionadoPago.getValue().toString()));
            nuevoPago.setAportesolidariopago(Integer.parseInt(txtAporteSolidarioPago.getValue().toString()));
            nuevoPago.setAportearl(Integer.parseInt(txtAporteArl.getValue().toString()));
            nuevoPago.setAhorrovoluntariopago(Integer.parseInt(txtAhorroVoluntarioPago.getValue().toString()));
            nuevoPago.setDependientespago(Integer.parseInt(txtDependientesPago.getValue().toString()));
            nuevoPago.setSaludprepagadapago(Integer.parseInt(txtSaludPrepagadaPago.getValue().toString()));
            nuevoPago.setInteresviviendapago(Integer.parseInt(txtInteresViviendaPago.getValue().toString()));
            
            pagoLogica.create(nuevoPago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El pago se  registro correctamente¡"));
            listaPago = null;
        } catch (NumberFormatException ex1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El codigo del pago debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡",ex.getMessage()));
        }
    }
    
    public void accion_seleccionar(SelectEvent event){
        Pago pagoSeleccionado=(Pago) event.getObject();
        txtCodigopago.setValue(pagoSeleccionado.getCodigopago());
        txtNumeroPago.setValue(pagoSeleccionado.getNumeropago().toString());
        txtFechaInicioPago=pagoSeleccionado.getFechainiciopago();
        txtFechaFinPago=pagoSeleccionado.getFechafinpago();
        txtSaldoAnteriorPago.setValue(pagoSeleccionado.getSaldoanteriorpago().toString());
        txtSaldoNuevoPago.setValue(pagoSeleccionado.getSaldonuevopago().toString());
        txtNumeroContratoPago.setValue(pagoSeleccionado.getNumerocontratopago().getNumerocontrato());
        txtNumeroHorasPago.setValue(pagoSeleccionado.getNumerohoraspago().toString());
        txtDiasLiquidacionPago.setValue(pagoSeleccionado.getDiasliquidarpago().toString());
        txtNumeroPlanillaPago.setValue(pagoSeleccionado.getNumeroplanillapago().toString());
        txtIbcPago.setValue(pagoSeleccionado.getIbcpago().toString());
        txtAportesSaludPago.setValue(pagoSeleccionado.getAportessaludpago());
        txtAportePensionadoPago.setValue(pagoSeleccionado.getAportepensionpago());
        txtAporteSolidarioPago.setValue(pagoSeleccionado.getAportesolidariopago().toString());
        txtAporteArl.setValue(pagoSeleccionado.getAportearl().toString());
        txtAhorroVoluntarioPago.setValue(pagoSeleccionado.getAhorrovoluntariopago().toString());
        txtDependientesPago.setValue(pagoSeleccionado.getDependientespago().toString());
        txtSaludPrepagadaPago.setValue(pagoSeleccionado.getSaludprepagadapago().toString());
        txtInteresViviendaPago.setValue(pagoSeleccionado.getInteresviviendapago().toString());        
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnLimpiar.setDisabled(true);    
    }
    public void accion_seleccionar_contrato(SelectEvent ex){
        Contrato contratoSeleccionado=selectedContrato;
        txtNumeroContratoPago.setValue(contratoSeleccionado.getNumerocontrato().toString());
        listaContrato=null;
    }
public void modificar(){
    try {
            Pago nuevoPago = new Pago();
            Contrato nuevoContrato = new Contrato();
            nuevoPago.setCodigopago(Integer.parseInt(txtCodigopago.getValue().toString()));
            nuevoPago.setNumeropago(Integer.parseInt(txtNumeroPago.getValue().toString()));
            nuevoPago.setFechainiciopago(txtFechaInicioPago);
            nuevoPago.setFechafinpago(txtFechaFinPago);
            nuevoPago.setSaldoanteriorpago(Integer.parseInt(txtSaldoAnteriorPago.getValue().toString()));
            nuevoPago.setSaldonuevopago(Integer.parseInt(txtSaldoNuevoPago.getValue().toString()));
            nuevoContrato.setNumerocontrato(Integer.parseInt(txtNumeroContratoPago.getValue().toString()));
            nuevoPago.setNumerocontratopago(nuevoContrato);
            nuevoPago.setNumerohoraspago(Integer.parseInt(txtNumeroHorasPago.getValue().toString()));
            nuevoPago.setDiasliquidarpago(Integer.parseInt(txtDiasLiquidacionPago.getValue().toString()));
            nuevoPago.setNumeroplanillapago(Integer.parseInt(txtNumeroPlanillaPago.getValue().toString())); 
            nuevoPago.setIbcpago(Integer.parseInt(txtIbcPago.getValue().toString()));            
            nuevoPago.setAportessaludpago(Integer.parseInt(txtAportesSaludPago.getValue().toString()));
            nuevoPago.setAportepensionpago(Integer.parseInt(txtAportePensionadoPago.getValue().toString()));
            nuevoPago.setAportesolidariopago(Integer.parseInt(txtAporteSolidarioPago.getValue().toString()));
            nuevoPago.setAportearl(Integer.parseInt(txtAporteArl.getValue().toString()));
            nuevoPago.setAhorrovoluntariopago(Integer.parseInt(txtAhorroVoluntarioPago.getValue().toString()));
            nuevoPago.setDependientespago(Integer.parseInt(txtDependientesPago.getValue().toString()));
            nuevoPago.setSaludprepagadapago(Integer.parseInt(txtSaludPrepagadaPago.getValue().toString()));
            nuevoPago.setInteresviviendapago(Integer.parseInt(txtInteresViviendaPago.getValue().toString()));
            
            pagoLogica.edit(nuevoPago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El pago se modifico correctamente¡"));
            listaPago = null;
            btnLimpiar.setDisabled(false);
        } catch (NumberFormatException ex1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El codigo del pago debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡",ex.getMessage()));
        }  
    }
    public void eliminar(){
        try {
            Pago pago = new Pago();
            pago.setCodigopago(Integer.parseInt(txtCodigopago.getValue().toString()));            
            pagoLogica.remove(pago);
            listaPago =null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El pago se eliminó con Éxito¡"));
        } catch (Exception ex) {
            Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cargarPago(FileUploadEvent event) {
        //System.out.println("Evento File upload!!!");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String rutaDestino = (String) servletContext.getRealPath("/excel");

        //System.out.println("Ruta Server: " + rutaDestino);
        try {
            copiarArchivo(rutaDestino, event.getFile().getFileName(), event.getFile().getInputstream());
            String resultado = pagoLogica.importarDatosPago(rutaDestino + "\\" + event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ok: ", resultado));
           
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ContratistaVista.class.getName()).log(Level.SEVERE, null, ex);
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
    public void generarReporte(){
        try {

                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                HttpServletRequest sr = ((HttpServletRequest) ec.getRequest());
                String scheme = sr.getScheme();
                String serverName = sr.getServerName();
                int port = sr.getServerPort();
                String contextPath = sr.getContextPath();
                String url = scheme + "://" + serverName + ":" + port + contextPath;
                pagoLogica.generarReportePago(url);
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
    }
    
}