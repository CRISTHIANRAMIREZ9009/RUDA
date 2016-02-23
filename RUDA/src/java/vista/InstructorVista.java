package vista;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logica.ContratoLogicaLocal;
import org.primefaces.component.inputtext.InputText;


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
    
    @EJB
    private ContratoLogicaLocal contratoLogica;
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

    public ContratoLogicaLocal getContratoLogica() {
        return contratoLogica;
    }

    public void setContratoLogica(ContratoLogicaLocal contratoLogica) {
        this.contratoLogica = contratoLogica;
    }
    
}
