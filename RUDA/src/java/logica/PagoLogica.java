
package logica;

import java.io.File;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import modelo.Contrato;
import modelo.Pago;
import org.primefaces.context.RequestContext;
import persistencia.PagoFacadeLocal;

@Stateless
public class PagoLogica implements PagoLogicaLocal {
    
    @EJB
    
    private PagoFacadeLocal pagoDAO;
    
    private int pagoInsertado;
    private int pagoExistente;

    @Override
    public void create(Pago pago) throws Exception {        
        Pago nuevoPago = pagoDAO.find(pago.getCodigopago());        
        if(pago!=null)
        {            
            if(pago.getCodigopago() == null)
            {                
                throw new Exception ("!El codigo del pago es obligatorio¡");                
            }            
        }        
        else
        {            
            throw new Exception ("!El pago no contiene informacion¡");            
        }        
        if(nuevoPago == null)
        {            
            pagoDAO.create(pago);            
        }        
        else
        {            
            throw new Exception ("!El pago ya esta creado¡");            
        }
    }

    @Override
    public void edit(Pago pago) throws Exception {
        Pago nuevoPago = pagoDAO.find(pago.getCodigopago());
        if(pago!=null)
        {            
            if(pago.getCodigopago() == null)
            {                
                throw new Exception ("!El codigo del pago es obligatorio¡");                
            }            
        }        
        else
        {            
            throw new Exception ("!El pago no contiene informacion¡");            
        }        
        if(nuevoPago == null)
        {
            throw new Exception ("!El pago no existe y no se puede modificar¡");                        
        }        
        else
        {  
            pagoDAO.edit(pago);
        }
    }

    @Override
    public void remove(Pago pago) throws Exception {        
        Pago nuevoPago = pagoDAO.find(pago.getCodigopago());
        if(pago!=null)
        {            
            if(pago.getCodigopago() == null)
            {                
                throw new Exception ("!El codigo del pago es obligatorio¡");                
            }            
        }        
        else
        {            
            throw new Exception ("!El pago no contiene informacion¡");            
        }        
        if(nuevoPago == null)
        {
            throw new Exception ("!El pago no existe y no se puede eliminar¡");                        
        }        
        else
        {  
            pagoDAO.remove(pago);
        }
    }

    @Override
    public Pago find(int codigopago) throws Exception {        
        if(codigopago!=0)
        {            
            return pagoDAO.find(codigopago);            
        }        
        else
        {            
            throw new Exception ("!El codigo del pago es obligatorio¡");            
        }
    }

    @Override
    public List<Pago> findAll() throws Exception {
        return pagoDAO.findAll();
    }

    @Override
    public String importarDatosPago(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();
        pagoInsertado = 0;
        pagoExistente = 0;
        for (int fila = 1; fila < numFilas; fila++) {            
            Pago nuevoPago = new Pago();            
            Contrato nuevoContrato = new Contrato();
            nuevoPago.setCodigopago(Integer.parseInt(hoja.getCell(0, fila).getContents()));
            nuevoPago.setNumeropago(Integer.parseInt(hoja.getCell(1, fila).getContents()));
            nuevoPago.setFechainiciopago(Date.valueOf(hoja.getCell(2, fila).getContents()));
            nuevoPago.setFechafinpago(Date.valueOf(hoja.getCell(3, fila).getContents()));
            nuevoPago.setSaldoanteriorpago(Integer.parseInt(hoja.getCell(4, fila).getContents()));
            nuevoPago.setSaldonuevopago(Integer.parseInt(hoja.getCell(5, fila).getContents()));
            nuevoContrato.setNumerocontrato(Integer.parseInt(hoja.getCell(6, fila).getContents()));
            nuevoPago.setNumerocontratopago(nuevoContrato);
            nuevoPago.setNumerohoraspago(Integer.parseInt(hoja.getCell(7, fila).getContents()));
            nuevoPago.setDiasliquidarpago(Integer.parseInt(hoja.getCell(8, fila).getContents()));
            nuevoPago.setNumeroplanillapago(Integer.parseInt(hoja.getCell(9, fila).getContents()));
            nuevoPago.setIbcpago(Integer.parseInt(hoja.getCell(10, fila).getContents()));
            nuevoPago.setAportessaludpago(Integer.parseInt(hoja.getCell(11, fila).getContents()));
            nuevoPago.setAportepensionpago(Integer.parseInt(hoja.getCell(12, fila).getContents()));
            nuevoPago.setAportesolidariopago(Integer.parseInt(hoja.getCell(13, fila).getContents()));
            nuevoPago.setAportearl(Integer.parseInt(hoja.getCell(14, fila).getContents()));
            nuevoPago.setAhorrovoluntariopago(Integer.parseInt(hoja.getCell(15, fila).getContents()));
            nuevoPago.setDependientespago(Integer.parseInt(hoja.getCell(16, fila).getContents()));
            nuevoPago.setSaludprepagadapago(Integer.parseInt(hoja.getCell(17, fila).getContents()));
            nuevoPago.setInteresviviendapago(Integer.parseInt(hoja.getCell(18, fila).getContents()));
            Pago pago = pagoDAO.find(nuevoPago.getCodigopago());
            if (pago == null) {
                pagoDAO.create(nuevoPago);
                pagoInsertado++;
            } else {
                pagoExistente++;
            }
        }
        
        return "Se registraron " + pagoInsertado + " matriculas. Ya existían " + pagoExistente;
    }

    @Override
    public void generarReportePago(String url) throws Exception {
        String params =
                "'"
                + url + "/ReportePago.do',"
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
        RequestContext.getCurrentInstance().execute("location.href=" + params + ";");        
        
    }
    
    

}
