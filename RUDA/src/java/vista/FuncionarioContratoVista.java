
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import logica.BancoLogicaLocal;
import logica.ContratoLogicaLocal;
import modelo.Banco;
import modelo.Contrato;
import modelo.Coordinador;
import modelo.Lineacentro;
import modelo.Personal;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import persistencia.BancoFacadeLocal;

@ManagedBean (name = "funcionarioContratoVista")
@RequestScoped
public class FuncionarioContratoVista {

    private InputText txtNumeroContrato;
    private Calendar txtFechaInicioContrato;
    private Calendar txtFechaFinContrato;
    private InputText txtObjetoContrato;
    private SelectOneMenu txtEstadoContrato;
    private InputText txtValorTotalContrato;
    private InputText txtNumeroCompromisoSiContrato;
    private InputText txtFormaPagoContrato;
    private InputText txtNumeroCuentaContrato;
    private InputText txtTipoCuentaContrato;
    private InputText txtCodigoBancoContrato;
    private InputText txtDocumentoCoordinadorContrato;
    private InputText txtDocumentoPersonalContrato;
    private SelectOneMenu cmbLineaContrato;
    private Lineacentro selectedCodigoLineaCentro;
    private InputText txtClasePersonaContrato;
    private InputText txtIngresosSuperioresContrato;
    private InputText txtRegimenIvaContrato;
    private InputText txtExcluidoIvaContrato;
    private InputText txtDeclaranteContrato;
    private InputText txtPensionadoContrato;
    private InputText txtDependientesContratp;
    private InputText txtEmbargoContrato;
    private InputText txtValorEmbargoContrato;
    private InputText txtValorMensualContrato;
    private InputText txtValorHoraContrato;
    private InputText txtTipoArlContrato;
    
    private CommandButton btnCodigoBanco;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnReporte;
    private CommandButton btnLimpiar;
    private List<Contrato> listaContratos;
    private Contrato selectedContrato;
    private List<Banco> listaBanco;
    private Banco selectedBanco;
    private List<SelectItem> seleccionarBanco;
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    
    @EJB
    private BancoLogicaLocal bancoLogica;
    
    @EJB
    private BancoFacadeLocal bancoDAO;
    
    public FuncionarioContratoVista() {
        
    }

    public InputText getTxtNumeroContrato() {
        return txtNumeroContrato;
    }

    public void setTxtNumeroContrato(InputText txtNumeroContrato) {
        this.txtNumeroContrato = txtNumeroContrato;
    }

    public Calendar getTxtFechaInicioContrato() {
        return txtFechaInicioContrato;
    }

    public void setTxtFechaInicioContrato(Calendar txtFechaInicioContrato) {
        this.txtFechaInicioContrato = txtFechaInicioContrato;
    }

    public Calendar getTxtFechaFinContrato() {
        return txtFechaFinContrato;
    }

    public void setTxtFechaFinContrato(Calendar txtFechaFinContrato) {
        this.txtFechaFinContrato = txtFechaFinContrato;
    }
    
    public InputText getTxtObjetoContrato() {
        return txtObjetoContrato;
    }

    public void setTxtObjetoContrato(InputText txtObjetoContrato) {
        this.txtObjetoContrato = txtObjetoContrato;
    }
    
    public SelectOneMenu getTxtEstadoContrato() {
        return txtEstadoContrato;
    }

    public void setTxtEstadoContrato(SelectOneMenu txtEstadoContrato) {
        this.txtEstadoContrato = txtEstadoContrato;
    }
    
    public InputText getTxtValorTotalContrato() {
        return txtValorTotalContrato;
    }

    public void setTxtValorTotalContrato(InputText txtValorTotalContrato) {
        this.txtValorTotalContrato = txtValorTotalContrato;
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

    public BancoFacadeLocal getBancoDAO() {
        return bancoDAO;
    }

    public void setBancoDAO(BancoFacadeLocal bancoDAO) {
        this.bancoDAO = bancoDAO;
    }

    public CommandButton getBtnCodigoBanco() {
        return btnCodigoBanco;
    }

    public void setBtnCodigoBanco(CommandButton btnCodigoBanco) {
        this.btnCodigoBanco = btnCodigoBanco;
    }
    
    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    
    public void setListaContratos(List<Contrato> listaContratos) {
        this.listaContratos = listaContratos;
    }

    public Contrato getSelectedContrato() {
        return selectedContrato;
    }

    public Banco getSelectedBanco() {
        return selectedBanco;
    }

    public void setSelectedBanco(Banco selectedBanco) {
        this.selectedBanco = selectedBanco;
    }

    public void setSelectedContrato(Contrato selectedContrato) {
        this.selectedContrato = selectedContrato;
    }

    public InputText getTxtNumeroCompromisoSiContrato() {
        return txtNumeroCompromisoSiContrato;
    }

    public void setTxtNumeroCompromisoSiContrato(InputText txtNumeroCompromisoSiContrato) {
        this.txtNumeroCompromisoSiContrato = txtNumeroCompromisoSiContrato;
    }

    public InputText getTxtFormaPagoContrato() {
        return txtFormaPagoContrato;
    }

    public void setTxtFormaPagoContrato(InputText txtFormaPagoContrato) {
        this.txtFormaPagoContrato = txtFormaPagoContrato;
    }

    public InputText getTxtNumeroCuentaContrato() {
        return txtNumeroCuentaContrato;
    }

    public void setTxtNumeroCuentaContrato(InputText txtNumeroCuentaContrato) {
        this.txtNumeroCuentaContrato = txtNumeroCuentaContrato;
    }

    public InputText getTxtTipoCuentaContrato() {
        return txtTipoCuentaContrato;
    }

    public void setTxtTipoCuentaContrato(InputText txtTipoCuentaContrato) {
        this.txtTipoCuentaContrato = txtTipoCuentaContrato;
    }

    public InputText getTxtCodigoBancoContrato() {
        return txtCodigoBancoContrato;
    }

    public void setTxtCodigoBancoContrato(InputText txtCodigoBancoContrato) {
        this.txtCodigoBancoContrato = txtCodigoBancoContrato;
    }

    public InputText getTxtDocumentoCoordinadorContrato() {
        return txtDocumentoCoordinadorContrato;
    }

    public void setTxtDocumentoCoordinadorContrato(InputText txtDocumentoCoordinadorContrato) {
        this.txtDocumentoCoordinadorContrato = txtDocumentoCoordinadorContrato;
    }

    public InputText getTxtDocumentoPersonalContrato() {
        return txtDocumentoPersonalContrato;
    }

    public void setTxtDocumentoPersonalContrato(InputText txtDocumentoPersonalContrato) {
        this.txtDocumentoPersonalContrato = txtDocumentoPersonalContrato;
    }

    public SelectOneMenu getCmbLineaContrato() {
        return cmbLineaContrato;
    }

    public void setCmbLineaContrato(SelectOneMenu cmbLineaContrato) {
        this.cmbLineaContrato = cmbLineaContrato;
    }

    public Lineacentro getSelectedCodigoLineaCentro() {
        return selectedCodigoLineaCentro;
    }

    public void setSelectedCodigoLineaCentro(Lineacentro selectedCodigoLineaCentro) {
        this.selectedCodigoLineaCentro = selectedCodigoLineaCentro;
    }

    public InputText getTxtClasePersonaContrato() {
        return txtClasePersonaContrato;
    }

    public void setTxtClasePersonaContrato(InputText txtClasePersonaContrato) {
        this.txtClasePersonaContrato = txtClasePersonaContrato;
    }

    public ContratoLogicaLocal getContratoLogica() {
        return contratoLogica;
    }

    public BancoLogicaLocal getBancoLogica() {
        return bancoLogica;
    }

    public void setBancoLogica(BancoLogicaLocal bancoLogica) {
        this.bancoLogica = bancoLogica;
    }

    public void setContratoLogica(ContratoLogicaLocal contratoLogica) {
        this.contratoLogica = contratoLogica;
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

    public InputText getTxtValorMensualContrato() {
        return txtValorMensualContrato;
    }

    public void setTxtValorMensualContrato(InputText txtValorMensualContrato) {
        this.txtValorMensualContrato = txtValorMensualContrato;
    }

    public InputText getTxtValorHoraContrato() {
        return txtValorHoraContrato;
    }

    public void setTxtValorHoraContrato(InputText txtValorHoraContrato) {
        this.txtValorHoraContrato = txtValorHoraContrato;
    }

    public InputText getTxtTipoArlContrato() {
        return txtTipoArlContrato;
    }

    public void setTxtTipoArlContrato(InputText txtTipoArlContrato) {
        this.txtTipoArlContrato = txtTipoArlContrato;
    }
    
    public List<Contrato> getListaContratos() {
        
        if(listaContratos==null)
        {
            try 
            {
                
                listaContratos = contratoLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaContratos;
        
    }

    public List<Banco> getListaBanco() {
        
        if(listaBanco==null)
        {
            try 
            {
                
                listaBanco = bancoLogica.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaBanco;
        
    }

    public void setListaBanco(List<Banco> listaBanco) {
        this.listaBanco = listaBanco;
    }

    public List<SelectItem> getSeleccionarBanco() {
        List<Banco> listaBancos = bancoDAO.findAll();
        seleccionarBanco = new ArrayList<>();
        for (int i = 0; i < listaBancos.size(); i++) {
            seleccionarBanco.add(new SelectItem(listaBancos.get(i).getCodigobanco(), listaBancos.get(i).getNombrebanco()));
        }
        return seleccionarBanco;
    }

    public void setSeleccionarBanco(List<SelectItem> seleccionarBanco) {
        this.seleccionarBanco = seleccionarBanco;
    }
    
    public void accion_registrar() {

        try {
            Contrato nuevaContrato = new Contrato();
            nuevaContrato.setNumerocontrato(Integer.parseInt(txtNumeroContrato.getValue().toString()));
            String fecha = txtFechaInicioContrato.getValue().toString();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            nuevaContrato.setFechainiciocontrato(formato.parse(fecha));
            String fecha2 = txtFechaFinContrato.getValue().toString();
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
            nuevaContrato.setFechafincontrato(formato2.parse(fecha2));
            nuevaContrato.setObjetocontrato(txtObjetoContrato.getValue().toString());
            nuevaContrato.setEstadocontrato(txtEstadoContrato.getValue().toString());
            nuevaContrato.setValortotalcontrato(BigInteger.valueOf(Long.parseLong(txtValorTotalContrato.getValue().toString())));
            nuevaContrato.setNumerocompromisosiifcontrato(Integer.parseInt(txtNumeroCompromisoSiContrato.getValue().toString()));
            nuevaContrato.setFormapagocontrato(txtFormaPagoContrato.getValue().toString()); 
            nuevaContrato.setNumerocuentacontrato(BigInteger.valueOf(Long.parseLong(txtNumeroCuentaContrato.getValue().toString())));            
            nuevaContrato.setTipocuentacontrato(txtTipoCuentaContrato.getValue().toString());
            Banco nuevoBanco = new Banco();
            nuevoBanco.setCodigobanco(Integer.parseInt(txtCodigoBancoContrato.getValue().toString()));
            nuevaContrato.setCodigobancocontrato(nuevoBanco);
            Coordinador nuevoCoordinador = new Coordinador();
            nuevoCoordinador.setDocumentocoordinador(Long.parseLong(txtDocumentoCoordinadorContrato.getValue().toString()));
            nuevaContrato.setDocumentocoordinadorcontrato(nuevoCoordinador);
            Personal nuevoPersonal = new Personal();
            nuevoPersonal.setDocumentopersonal(Long.parseLong(txtDocumentoPersonalContrato.getValue().toString()));
            nuevaContrato.setDocumentopersonalcontrato(nuevoPersonal);
            Lineacentro nuevoLineacentro = new Lineacentro();
            nuevoLineacentro.setCodigolinea(Integer.parseInt(cmbLineaContrato.getValue().toString()));
            nuevaContrato.setCodigolineacontrato(nuevoLineacentro);
            contratoLogica.create(nuevaContrato);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El contrato se  registro correctamente¡"));
            listaContratos = null;
        } catch (NumberFormatException ex1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El numero del contrato debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡",ex.getMessage()));
        }
    }
    
    public void seleccionar(SelectEvent event){
        Contrato contratoSeleccionado = (Contrato) event.getObject();
        txtNumeroContrato.setValue(contratoSeleccionado.getNumerocuentacontrato());
        txtFechaInicioContrato.setValue(contratoSeleccionado.getFechainiciocontrato());
        txtFechaFinContrato.setValue(contratoSeleccionado.getFechafincontrato());
        txtObjetoContrato.setValue(contratoSeleccionado.getObjetocontrato());
        txtEstadoContrato.setValue(contratoSeleccionado.getEstadocontrato());
        txtValorTotalContrato.setValue(contratoSeleccionado.getValortotalcontrato());        
        txtNumeroCompromisoSiContrato.setValue(contratoSeleccionado.getNumerocompromisosiifcontrato());
        txtFormaPagoContrato.setValue(contratoSeleccionado.getFormapagocontrato());
        txtNumeroCuentaContrato.setValue(contratoSeleccionado.getNumerocuentacontrato());
        txtTipoCuentaContrato.setValue(contratoSeleccionado.getTipocuentacontrato());
        txtCodigoBancoContrato.setValue(contratoSeleccionado.getCodigobancocontrato().getCodigobanco());
        txtDocumentoCoordinadorContrato.setValue(contratoSeleccionado.getDocumentocoordinadorcontrato().getDocumentocoordinador());
        txtDocumentoPersonalContrato.setValue(contratoSeleccionado.getDocumentopersonalcontrato().getDocumentopersonal());
        cmbLineaContrato.setValue(contratoSeleccionado.getCodigolineacontrato().getCodigolinea());
        btnModificar.setDisabled(false);
        btnRegistrar.setDisabled(true);
        btnLimpiar.setDisabled(true);
    }
    
    public void seleccionarBanco(SelectEvent event){
        Banco BancoSeleccionado = (Banco) event.getObject();
        txtCodigoBancoContrato.setValue(BancoSeleccionado.getCodigobanco());
    }
    
    public void modificar(){
    try {
        Contrato objetoContrato = new Contrato();
        objetoContrato.setNumerocontrato(Integer.parseInt(txtNumeroContrato.getValue()+""));
        objetoContrato.setObjetocontrato(txtObjetoContrato.getValue()+"");
        objetoContrato.setValortotalcontrato(BigInteger.valueOf(Long.parseLong(txtValorTotalContrato.getValue().toString())));
        objetoContrato.setNumerocompromisosiifcontrato(Integer.parseInt(txtNumeroCompromisoSiContrato.getValue()+""));
        objetoContrato.setValorembargocontrato(Integer.parseInt(txtValorEmbargoContrato.getValue()+""));
        objetoContrato.setValormensualcontrato(BigInteger.valueOf(Long.parseLong(txtValorMensualContrato.getValue().toString())));
        objetoContrato.setValorhoracontrato(Integer.parseInt(txtValorHoraContrato.getValue()+""));
        contratoLogica.edit(objetoContrato);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "!El contrato se  modifico correctamente¡"));
        listaContratos = null;
    } catch (Exception ex) {
        Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void limpiar() {
        txtNumeroContrato.setValue("");
        txtFechaInicioContrato.setValue("");
        txtFechaFinContrato.setValue("");
        txtObjetoContrato.setValue("");
        txtEstadoContrato.setValue("");
        txtValorTotalContrato.setValue("");
        txtNumeroCompromisoSiContrato.setValue("");
        txtFormaPagoContrato.setValue("");
        txtNumeroCuentaContrato.setValue("");
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(true);
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
            Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("Entro aqui");
                contratoLogica.generarReporteContrato(url);

            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
            }
        
    }
    
}
    
