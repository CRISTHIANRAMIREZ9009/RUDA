
package logica;

import java.io.File;
import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import modelo.Banco;
import modelo.Contrato;
import modelo.Coordinador;
import modelo.Lineacentro;
import modelo.Personal;
import org.primefaces.context.RequestContext;
import persistencia.ContratoFacadeLocal;

@Stateless
public class ContratoLogica implements ContratoLogicaLocal {
    
    @EJB
    
    private ContratoFacadeLocal contratoDAO;
    
    private int contratoInsertado;
    private int contratoExistente;

    @Override
    public void create(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            contratoDAO.create(contrato);
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato ya esta creado¡");
            
        }
        
    }

    @Override
    public void edit(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            throw new Exception ("!El contrato no exite y no se puede modificar¡");
            
        }
        
        else
        {
            
            contratoDAO.edit(contrato);
            
        }
        
    }

    @Override
    public void remove(Contrato contrato) throws Exception {
        
        Contrato nuevoContrato = contratoDAO.find(contrato.getNumerocontrato());
        
        if(contrato!=null)
        {
            
            if(contrato.getNumerocontrato() == null)
            {
                
                throw new Exception ("!El numero del contrato es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El contrato no contiene informacion¡");
            
        }
        
        if(nuevoContrato == null)
        {
            
            throw new Exception ("!El contrato no exite y no se puede eliminar¡");
            
        }
        
        else
        {
            
            contratoDAO.remove(contrato);
            
        }
        
    }

    @Override
    public Contrato find(Integer numerocontrato) throws Exception {
        
        if(numerocontrato!=null)
        {
            
            return contratoDAO.find(numerocontrato);
            
        }
        
        else
        {
            
            throw new Exception ("!El numero de contrato es obligatorio para la busqueda¡");
            
        }
        
    }
    
    @Override
    public List<Contrato> findAll() throws Exception {
        return contratoDAO.findAll();
    }

    @Override
    public String importarDatosContrato(String archivo) throws Exception {
        
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();
        
        contratoInsertado = 0;
        contratoExistente = 0;

        for (int fila = 1; fila < numFilas; fila++) {
            
            Contrato nuevoContrato = new Contrato();
            Banco objetoBanco = new Banco();
            Coordinador objetoCoordinador = new Coordinador();
            Personal objetoPersonal = new Personal();
            Lineacentro objetoLinea = new Lineacentro();

            nuevoContrato.setNumerocontrato(Integer.parseInt(hoja.getCell(0, fila).getContents()));
            nuevoContrato.setFechainiciocontrato(Date.valueOf(hoja.getCell(1, fila).getContents()));
            nuevoContrato.setFechafincontrato(Date.valueOf(hoja.getCell(2, fila).getContents()));
            nuevoContrato.setObjetocontrato(hoja.getCell(3, fila).getContents());
            nuevoContrato.setEstadocontrato(hoja.getCell(4, fila).getContents());
            nuevoContrato.setValortotalcontrato(BigInteger.valueOf(Long.parseLong(hoja.getCell(5, fila).getContents())));
            nuevoContrato.setNumerocompromisosiifcontrato(Integer.parseInt(hoja.getCell(6, fila).getContents()));
            nuevoContrato.setFormapagocontrato(hoja.getCell(7, fila).getContents());
            nuevoContrato.setNumerocuentacontrato(BigInteger.valueOf(Long.parseLong(hoja.getCell(8, fila).getContents())));
            nuevoContrato.setTipocuentacontrato(hoja.getCell(9, fila).getContents());
            objetoBanco.setCodigobanco(Integer.parseInt(hoja.getCell(10, fila).getContents()));
            nuevoContrato.setCodigobancocontrato(objetoBanco);
            objetoCoordinador.setDocumentocoordinador(Long.parseLong(hoja.getCell(11, fila).getContents()));
            nuevoContrato.setDocumentocoordinadorcontrato(objetoCoordinador);
            objetoPersonal.setDocumentopersonal(Long.parseLong(hoja.getCell(12, fila).getContents()));
            nuevoContrato.setDocumentopersonalcontrato(objetoPersonal);
            objetoLinea.setCodigolinea(Integer.parseInt(hoja.getCell(13, fila).getContents()));
            nuevoContrato.setCodigolineacontrato(objetoLinea);
            nuevoContrato.setClasepersonacontrato(hoja.getCell(14, fila).getContents());
            nuevoContrato.setIngresossuperiorescontrato(hoja.getCell(15, fila).getContents());
            nuevoContrato.setRegimenivacontrato(hoja.getCell(16, fila).getContents());
            nuevoContrato.setExcluidoivacontrato(hoja.getCell(17, fila).getContents());
            nuevoContrato.setDeclarantecontrato(hoja.getCell(18, fila).getContents());
            nuevoContrato.setPensionadocontrato(hoja.getCell(19, fila).getContents());
            nuevoContrato.setDependientescontratp(hoja.getCell(20, fila).getContents());
            nuevoContrato.setEmbargocontrato(hoja.getCell(21, fila).getContents());
            nuevoContrato.setValorembargocontrato(Integer.parseInt(hoja.getCell(22, fila).getContents()));
            nuevoContrato.setValormensualcontrato(BigInteger.valueOf(Long.parseLong(hoja.getCell(23, fila).getContents())));
            nuevoContrato.setValorhoracontrato(Integer.parseInt(hoja.getCell(24, fila).getContents()));
            nuevoContrato.setTipoarlcontrato(Integer.parseInt(hoja.getCell(25, fila).getContents()));

            Contrato contrato = contratoDAO.find(nuevoContrato.getNumerocontrato());
            if (contrato == null) {
                contratoDAO.create(nuevoContrato);
                contratoInsertado++;
            } else {
                contratoExistente++;
            }
        }
        
        return "!Se registraron " + contratoInsertado + " contrato. Ya existían " + contratoExistente + ".";
        
    }

    @Override
    public void generarReporteContrato(String url) throws Exception {
        
        String params = "'"
                + url + "/reporteContrato.do',"
                + "'reportWindow', "
                + "'"
                + "width=1024"
                + ",height=768"
                + ",status=no"
                + ",toolbar=no"
                + ",menubar=no"
                + ",location=no"
                + ",scrollbars=yes"
                + "'";

        System.out.println(params);

        RequestContext.getCurrentInstance().execute("location.href=" + params + ";");
        
    }
   
}
