
package vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import logica.ContratoLogicaLocal;
import modelo.Banco;
import modelo.Contrato;
import modelo.Coordinador;
import modelo.Lineacentro;
import modelo.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import persistencia.BancoFacadeLocal;

@ManagedBean (name = "funcionarioContratoVista")
@RequestScoped
public class FuncionarioContratoVista {

    private InputText txtNumeroContrato;
    private InputText txtFechaInicioContrato;
    private InputText txtFechaFinContrato;
    private InputText txtObjetoContrato;
    private InputText txtEstadoContrato;
    private InputText txtValorTotalContrato;
    private InputText txtNumeroCompromisoSiContrato;
    private InputText txtFormaPagoContrato;
    private InputText txtNumeroCuentaContrato;
    private InputText txtTipoCuentaContrato;
    private InputText txtCodigoBancoContrato;
    private Banco selectedCodigoBancoContrato;
    private Coordinador selectedDocumentoCoordinadorContrato;
    private Personal selectedDocumentoPersonalContrato;
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
    
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private List<Contrato> listaContratos;
    private Contrato selectedContrato;
    private List<SelectItem> seleccionarBanco;
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    
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
    
    public InputText getTxtObjetoContrato() {
        return txtObjetoContrato;
    }

    public void setTxtObjetoContrato(InputText txtObjetoContrato) {
        this.txtObjetoContrato = txtObjetoContrato;
    }
    
    public InputText getTxtEstadoContrato() {
        return txtEstadoContrato;
    }

    public void setTxtEstadoContrato(InputText txtEstadoContrato) {
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

    public Banco getSelectedCodigoBancoContrato() {
        return selectedCodigoBancoContrato;
    }

    public void setSelectedCodigoBancoContrato(Banco selectedCodigoBancoContrato) {
        this.selectedCodigoBancoContrato = selectedCodigoBancoContrato;
    }

    public Coordinador getSelectedDocumentoCoordinadorContrato() {
        return selectedDocumentoCoordinadorContrato;
    }

    public void setSelectedDocumentoCoordinadorContrato(Coordinador selectedDocumentoCoordinadorContrato) {
        this.selectedDocumentoCoordinadorContrato = selectedDocumentoCoordinadorContrato;
    }

    public Personal getSelectedDocumentoPersonalContrato() {
        return selectedDocumentoPersonalContrato;
    }

    public void setSelectedDocumentoPersonalContrato(Personal selectedDocumentoPersonalContrato) {
        this.selectedDocumentoPersonalContrato = selectedDocumentoPersonalContrato;
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
    
    public void seleccionar(SelectEvent e){
        Contrato contratoSeleccionado = selectedContrato;
        txtNumeroContrato.setValue(contratoSeleccionado.getNumerocontrato()+"");
        txtFechaInicioContrato.setValue(contratoSeleccionado.getFechainiciocontrato());
        txtFechaFinContrato.setValue(contratoSeleccionado.getFechafincontrato());
        txtObjetoContrato.setValue(contratoSeleccionado.getObjetocontrato());
        txtValorTotalContrato.setValue(contratoSeleccionado.getValortotalcontrato()+"");
        txtNumeroCompromisoSiContrato.setValue(contratoSeleccionado.getNumerocompromisosiifcontrato()+"");
        btnModificar.setDisabled(false);
        btnRegistrar.setDisabled(true);
        btnLimpiar.setDisabled(true);
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
        txtValorTotalContrato.setValue("");
        txtNumeroCompromisoSiContrato.setValue("");
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
    
}
    
