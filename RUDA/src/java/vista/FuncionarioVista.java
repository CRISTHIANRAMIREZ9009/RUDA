
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logica.ContratoLogicaLocal;
import modelo.Banco;
import modelo.Contrato;
import modelo.Coordinador;
import modelo.Instructor;
import modelo.Lineacentro;
import modelo.Personal;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

@ManagedBean (name = "funcionarioVista")
@RequestScoped
public class FuncionarioVista {

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
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
    
    public FuncionarioVista() {
        
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
                
                Logger.getLogger(FuncionarioVista.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
        }
        
        return listaContratos;
        
    }
    
    /*public void seleccionar(SelectEvent e){
        Contrato contratoSeleccionado = selectedContrato;
        txtdocumentoDocente.setValue(d.getDocumentodocente()+"");
        txtNombreDocente.setValue(d.getNombredocente());
        btnModificar.setDisabled(false);
        btnRegistrar.setDisabled(true);
    }
    
    public void modificar(){
    try {
        Docente nuevoDocente = new Docente();
        nuevoDocente.setDocumentodocente(Long.parseLong(txtdocumentoDocente.getValue().toString()));
        nuevoDocente.setNombredocente(txtNombreDocente.getValue().toString());
        nuevoDocente.setApellidodocente(txtApellidoDocente.getValue().toString());
        nuevoDocente.setCorreodocente(txtCorreoDocente.getValue().toString());
        nuevoDocente.setTelefonodocente(txtTlelefonodocente.getValue().toString());
        nuevoDocente.setProfesiondocente(txtProfesionDocente.getValue().toString());
        nuevoDocente.setClavedocente(txtClaveDocente.getValue().toString());
        nuevoDocente.setMateriaList(listaMateriasSeleccionadas);
        docentelogica.edit(nuevoDocente);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El docente se  modifico correctamente"));
        listaDocente = null;
    } catch (Exception ex) {
        Logger.getLogger(DocenteVista.class.getName()).log(Level.SEVERE, null, ex);
    }
    }*/
    
}
