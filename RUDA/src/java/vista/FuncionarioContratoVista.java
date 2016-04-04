
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
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
import logica.BancoLogicaLocal;
import logica.ContratoLogicaLocal;
import logica.LineaCentroLogicaLocal;
import modelo.Banco;
import modelo.Contrato;
import modelo.Coordinador;
import modelo.Lineacentro;
import modelo.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import persistencia.BancoFacadeLocal;
import persistencia.CoordinadorFacadeLocal;
import persistencia.LineacentroFacadeLocal;
import persistencia.PersonalFacadeLocal;

@ManagedBean (name = "funcionarioContratoVista")
@RequestScoped
public class FuncionarioContratoVista {

    private InputText txtNumeroContrato;
    private Date txtFechaInicioContrato;
    private Date txtFechaFinContrato;
    private InputText txtObjetoContrato;
    private SelectOneMenu cmbEstadoContrato;
    private SelectOneMenu cmbFormaPagoContrato;
    private SelectOneMenu cmbTipoCuentaContrato;
    private SelectOneMenu cmbClasePersonaContrato;
    private SelectOneMenu cmbIngresosSuperioresContrato;
    private SelectOneMenu cmbRegimenIvaContrato;
    private SelectOneMenu cmbExcluidoIvaContrato;
    private SelectOneMenu cmbDependientesContratp;
    private SelectOneMenu cmbPensionadoContrato;
    private SelectOneMenu cmbEmbargoContrato;
    private SelectOneMenu cmbTipoArlContrato;
    private SelectOneMenu cmbDeclaranteContrato;
    private InputText txtValorTotalContrato;
    private InputText txtNumeroCompromisoSiContrato;
    private InputText txtNumeroCuentaContrato;
    private InputText txtCodigoBancoContrato;
    private InputText txtDocumentoCoordinadorContrato;
    private InputText txtDocumentoPersonalContrato;
    private InputText txtCodigoLineaContrato;
    private Lineacentro selectedCodigoLineaCentro;
    private InputText txtValorEmbargoContrato;
    private InputText txtValorMensualContrato;
    private InputText txtValorHoraContrato;
    
    private CommandButton btnCodigoBanco;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnReporte;
    private CommandButton btnLimpiar;
    private List<Contrato> listaContratos;
    private Contrato selectedContrato;
    private List<Banco> listaBanco;
    private Banco selectedBanco;
    private List<Coordinador> listaCoordinador;
    private Coordinador selectedCoordinador;
    private List<Personal> listaPersonal;
    private Personal selectedPersonal;
    private List<Lineacentro> listaLineaCentro;
    private Lineacentro selectedLineaCentro;
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    
    @EJB
    private CoordinadorFacadeLocal coordinadorDAO;
    
    @EJB
    private PersonalFacadeLocal personalDAO;
    
    @EJB
    private BancoLogicaLocal bancoLogica;
    
    @EJB
    private BancoFacadeLocal bancoDAO;
    
    @EJB
    private LineaCentroLogicaLocal lineacentroLogica;
    
    @EJB
    private LineacentroFacadeLocal lineaCentroDAO;
    
    public FuncionarioContratoVista() {
        
    }

    public InputText getTxtNumeroContrato() {
        return txtNumeroContrato;
    }

    public void setTxtNumeroContrato(InputText txtNumeroContrato) {
        this.txtNumeroContrato = txtNumeroContrato;
    }

    public Date getTxtFechaInicioContrato() {
        return txtFechaInicioContrato;
    }

    public void setTxtFechaInicioContrato(Date txtFechaInicioContrato) {
        this.txtFechaInicioContrato = txtFechaInicioContrato;
    }

    public Date getTxtFechaFinContrato() {
        return txtFechaFinContrato;
    }

    public void setTxtFechaFinContrato(Date txtFechaFinContrato) {
        this.txtFechaFinContrato = txtFechaFinContrato;
    }
    
    public InputText getTxtObjetoContrato() {
        return txtObjetoContrato;
    }

    public void setTxtObjetoContrato(InputText txtObjetoContrato) {
        this.txtObjetoContrato = txtObjetoContrato;
    }   

    public SelectOneMenu getCmbEstadoContrato() {
        return cmbEstadoContrato;
    }

    public void setCmbEstadoContrato(SelectOneMenu cmbEstadoContrato) {
        this.cmbEstadoContrato = cmbEstadoContrato;
    }

    public SelectOneMenu getCmbFormaPagoContrato() {
        return cmbFormaPagoContrato;
    }

    public void setCmbFormaPagoContrato(SelectOneMenu cmbFormaPagoContrato) {
        this.cmbFormaPagoContrato = cmbFormaPagoContrato;
    }

    public SelectOneMenu getCmbTipoCuentaContrato() {
        return cmbTipoCuentaContrato;
    }

    public void setCmbTipoCuentaContrato(SelectOneMenu cmbTipoCuentaContrato) {
        this.cmbTipoCuentaContrato = cmbTipoCuentaContrato;
    }

    public SelectOneMenu getCmbClasePersonaContrato() {
        return cmbClasePersonaContrato;
    }

    public void setCmbClasePersonaContrato(SelectOneMenu cmbClasePersonaContrato) {
        this.cmbClasePersonaContrato = cmbClasePersonaContrato;
    }

    public SelectOneMenu getCmbIngresosSuperioresContrato() {
        return cmbIngresosSuperioresContrato;
    }

    public void setCmbIngresosSuperioresContrato(SelectOneMenu cmbIngresosSuperioresContrato) {
        this.cmbIngresosSuperioresContrato = cmbIngresosSuperioresContrato;
    }

    public SelectOneMenu getCmbRegimenIvaContrato() {
        return cmbRegimenIvaContrato;
    }

    public void setCmbRegimenIvaContrato(SelectOneMenu cmbRegimenIvaContrato) {
        this.cmbRegimenIvaContrato = cmbRegimenIvaContrato;
    }

    public SelectOneMenu getCmbExcluidoIvaContrato() {
        return cmbExcluidoIvaContrato;
    }

    public void setCmbExcluidoIvaContrato(SelectOneMenu cmbExcluidoIvaContrato) {
        this.cmbExcluidoIvaContrato = cmbExcluidoIvaContrato;
    }

    public SelectOneMenu getCmbDependientesContratp() {
        return cmbDependientesContratp;
    }

    public void setCmbDependientesContratp(SelectOneMenu cmbDependientesContratp) {
        this.cmbDependientesContratp = cmbDependientesContratp;
    }

    public SelectOneMenu getCmbPensionadoContrato() {
        return cmbPensionadoContrato;
    }

    public void setCmbPensionadoContrato(SelectOneMenu cmbPensionadoContrato) {
        this.cmbPensionadoContrato = cmbPensionadoContrato;
    }

    public SelectOneMenu getCmbEmbargoContrato() {
        return cmbEmbargoContrato;
    }

    public void setCmbEmbargoContrato(SelectOneMenu cmbEmbargoContrato) {
        this.cmbEmbargoContrato = cmbEmbargoContrato;
    }

    public SelectOneMenu getCmbTipoArlContrato() {
        return cmbTipoArlContrato;
    }

    public void setCmbTipoArlContrato(SelectOneMenu cmbTipoArlContrato) {
        this.cmbTipoArlContrato = cmbTipoArlContrato;
    }

    public SelectOneMenu getCmbDeclaranteContrato() {
        return cmbDeclaranteContrato;
    }

    public void setCmbDeclaranteContrato(SelectOneMenu cmbDeclaranteContrato) {
        this.cmbDeclaranteContrato = cmbDeclaranteContrato;
    }

    public InputText getTxtNumeroCuentaContrato() {
        return txtNumeroCuentaContrato;
    }

    public void setTxtNumeroCuentaContrato(InputText txtNumeroCuentaContrato) {
        this.txtNumeroCuentaContrato = txtNumeroCuentaContrato;
    }
        
    public InputText getTxtValorTotalContrato() {
        return txtValorTotalContrato;
    }

    public void setTxtValorTotalContrato(InputText txtValorTotalContrato) {
        this.txtValorTotalContrato = txtValorTotalContrato;
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

    public List<Coordinador> getListaCoordinador() {
        
        if(listaCoordinador==null)
        {
            try 
            {
                
                listaCoordinador = coordinadorDAO.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaCoordinador;
        
    }

    public List<Personal> getListaPersonal() {
        
        if(listaPersonal==null)
        {
            try 
            {
                
                listaPersonal = personalDAO.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaPersonal;        
        
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

    public List<Lineacentro> getListaLineaCentro() {
        
        if(listaLineaCentro==null)
        {
            try 
            {
                
                listaLineaCentro = lineaCentroDAO.findAll();
                
            } catch (Exception ex) 
            {
                
                Logger.getLogger(FuncionarioContratoVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaLineaCentro;
    }

    public void setListaLineaCentro(List<Lineacentro> listaLineaCentro) {
        this.listaLineaCentro = listaLineaCentro;
    }

    public Lineacentro getSelectedLineaCentro() {
        return selectedLineaCentro;
    }

    public void setSelectedLineaCentro(Lineacentro selectedLineaCentro) {
        this.selectedLineaCentro = selectedLineaCentro;
    }

    public void setListaBanco(List<Banco> listaBanco) {
        this.listaBanco = listaBanco;
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

    public void setListaCoordinador(List<Coordinador> listaCoordinador) {
        this.listaCoordinador = listaCoordinador;
    }

    public Coordinador getSelectedCoordinador() {
        return selectedCoordinador;
    }

    public void setSelectedCoordinador(Coordinador selectedCoordinador) {
        this.selectedCoordinador = selectedCoordinador;
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

    public InputText getTxtCodigoLineaContrato() {
        return txtCodigoLineaContrato;
    }

    public void setTxtCodigoLineaContrato(InputText txtCodigoLineaContrato) {
        this.txtCodigoLineaContrato = txtCodigoLineaContrato;
    }

    public Lineacentro getSelectedCodigoLineaCentro() {
        return selectedCodigoLineaCentro;
    }

    public void setSelectedCodigoLineaCentro(Lineacentro selectedCodigoLineaCentro) {
        this.selectedCodigoLineaCentro = selectedCodigoLineaCentro;
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
    
    public void accion_registrar() {

        try {
            Contrato nuevaContrato = new Contrato();
            nuevaContrato.setNumerocontrato(Integer.parseInt(txtNumeroContrato.getValue().toString()));
            nuevaContrato.setFechainiciocontrato(txtFechaInicioContrato);
            nuevaContrato.setFechafincontrato(txtFechaFinContrato);
            nuevaContrato.setObjetocontrato(txtObjetoContrato.getValue().toString());
            nuevaContrato.setEstadocontrato(cmbEstadoContrato.getValue().toString());
            nuevaContrato.setValortotalcontrato(BigInteger.valueOf(Long.parseLong(txtValorTotalContrato.getValue().toString())));
            nuevaContrato.setNumerocompromisosiifcontrato(Integer.parseInt(txtNumeroCompromisoSiContrato.getValue().toString()));
            nuevaContrato.setFormapagocontrato(cmbFormaPagoContrato.getValue().toString()); 
            nuevaContrato.setNumerocuentacontrato(BigInteger.valueOf(Long.parseLong(txtNumeroCuentaContrato.getValue().toString())));            
            nuevaContrato.setTipocuentacontrato(cmbTipoCuentaContrato.getValue().toString());
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
            nuevoLineacentro.setCodigolinea(Integer.parseInt(txtCodigoLineaContrato.getValue().toString()));
            nuevaContrato.setCodigolineacontrato(nuevoLineacentro);
            nuevaContrato.setClasepersonacontrato(cmbClasePersonaContrato.getValue().toString());
            nuevaContrato.setIngresossuperiorescontrato(cmbIngresosSuperioresContrato.getValue().toString());
            nuevaContrato.setRegimenivacontrato(cmbRegimenIvaContrato.getValue().toString());
            nuevaContrato.setExcluidoivacontrato(cmbExcluidoIvaContrato.getValue().toString());
            nuevaContrato.setDeclarantecontrato(cmbDeclaranteContrato.getValue().toString());
            nuevaContrato.setPensionadocontrato(cmbPensionadoContrato.getValue().toString());
            nuevaContrato.setDependientescontratp(cmbDependientesContratp.getValue().toString());
            nuevaContrato.setEmbargocontrato(cmbEmbargoContrato.getValue().toString());
            nuevaContrato.setValorembargocontrato(Integer.parseInt(txtValorEmbargoContrato.getValue().toString()));
            nuevaContrato.setValormensualcontrato(BigInteger.valueOf(Long.parseLong(txtValorMensualContrato.getValue().toString())));
            nuevaContrato.setValorhoracontrato(Integer.parseInt(txtValorHoraContrato.getValue().toString()));
            nuevaContrato.setTipoarlcontrato(Integer.parseInt(cmbTipoArlContrato.getValue().toString()));
            contratoLogica.create(nuevaContrato);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "!El contrato se  registro correctamente¡"));
            listaContratos = null;
        } catch (NumberFormatException ex1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡", "!El numero del contrato debe ser un numero y no letras¡"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "!Error¡",ex.getMessage()));
        }
    }
    
    public void seleccionar(SelectEvent ex){
        Contrato contratoSeleccionado = selectedContrato;
        txtNumeroContrato.setValue(contratoSeleccionado.getNumerocuentacontrato());
        txtFechaInicioContrato = contratoSeleccionado.getFechainiciocontrato();
        txtFechaFinContrato = contratoSeleccionado.getFechafincontrato();
        txtObjetoContrato.setValue(contratoSeleccionado.getObjetocontrato());
        cmbEstadoContrato.setValue(contratoSeleccionado.getEstadocontrato());
        cmbEstadoContrato.setLabel(contratoSeleccionado.getEstadocontrato());
        txtValorTotalContrato.setValue(contratoSeleccionado.getValortotalcontrato());        
        txtNumeroCompromisoSiContrato.setValue(contratoSeleccionado.getNumerocompromisosiifcontrato());
        cmbFormaPagoContrato.setValue(contratoSeleccionado.getFormapagocontrato());
        cmbFormaPagoContrato.setLabel(contratoSeleccionado.getFormapagocontrato());
        txtNumeroCuentaContrato.setValue(contratoSeleccionado.getNumerocuentacontrato());
        cmbTipoCuentaContrato.setValue(contratoSeleccionado.getTipocuentacontrato());
        cmbTipoCuentaContrato.setLabel(contratoSeleccionado.getTipocuentacontrato());
        txtCodigoBancoContrato.setValue(contratoSeleccionado.getCodigobancocontrato().getCodigobanco());
        txtDocumentoCoordinadorContrato.setValue(contratoSeleccionado.getDocumentocoordinadorcontrato().getDocumentocoordinador());
        txtDocumentoPersonalContrato.setValue(contratoSeleccionado.getDocumentopersonalcontrato().getDocumentopersonal());
        btnModificar.setDisabled(false);
        btnRegistrar.setDisabled(true);
        btnLimpiar.setDisabled(true);
    }
    
    public void seleccionarBanco(SelectEvent ex){
        
        Banco BancoSeleccionado = selectedBanco;
        txtCodigoBancoContrato.setValue(BancoSeleccionado.getCodigobanco());
        listaBanco = null;
        
    }
    
    public void seleccionarPersonal(SelectEvent ex)
    {
        
        Personal PersonalSeleccionado = selectedPersonal;
        txtDocumentoPersonalContrato.setValue(PersonalSeleccionado.getDocumentopersonal());
        listaPersonal = null;
        
    }
    
    public void seleccionarLineaCentro(SelectEvent ex)
    {
        
        Lineacentro LineaCentroSeleccionado = selectedLineaCentro;
        txtCodigoLineaContrato.setValue(LineaCentroSeleccionado.getCodigolinea());
        listaLineaCentro = null;
        
    }
    
    public void seleccionarCoordinador(SelectEvent ex)
    {
        
        Coordinador coordinadorSeleccionado = selectedCoordinador;
        txtDocumentoCoordinadorContrato.setValue(coordinadorSeleccionado.getDocumentocoordinador());
        listaCoordinador = null;
        
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
        cmbEstadoContrato.setValue("ACTIVO");
        cmbEstadoContrato.setLabel("ACTIVO");
        cmbTipoCuentaContrato.setValue("AHORROS");
        cmbTipoCuentaContrato.setLabel("AHORROS");
        txtNumeroContrato.setValue("");
        txtFechaInicioContrato.setDate(0);
        txtFechaFinContrato.setDate(0);
        txtObjetoContrato.setValue("");       
        txtValorTotalContrato.setValue("");
        txtNumeroCompromisoSiContrato.setValue("");        
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
                System.out.println("Entro aqui");
                contratoLogica.generarReporteContrato(url);
                
        }
        catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", ex.getMessage()));
        }
        
    }   
     
}
    
