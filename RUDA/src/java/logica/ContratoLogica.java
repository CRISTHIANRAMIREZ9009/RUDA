
package logica;

import java.io.File;
import java.math.BigInteger;
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
        Banco objetoBanco = new Banco();
        Coordinador objetoCoordinador = new Coordinador();
        Personal objetoPersonal = new Personal();
        Lineacentro objetoLinea = new Lineacentro();

        contratoInsertado = 0;
        contratoExistente = 0;

        for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
            Contrato nuevoContrato = new Contrato();

            nuevoContrato.setNumerocontrato(Integer.parseInt(hoja.getCell(0, fila).getContents()));
            SimpleDateFormat formatoFechaInicio = new SimpleDateFormat("yyyy/MM/dd");
            nuevoContrato.setFechainiciocontrato(formatoFechaInicio.parse(hoja.getCell(1, fila).getContents()));
            SimpleDateFormat formatoFechaFin = new SimpleDateFormat("yyyy/MM/dd");
            nuevoContrato.setFechafincontrato(formatoFechaFin.parse(hoja.getCell(2, fila).getContents()));
            nuevoContrato.setObjetocontrato(hoja.getCell(3, fila).getContents());
            nuevoContrato.setEstadocontrato(hoja.getCell(4, fila).getContents());
            nuevoContrato.setValortotalcontrato(BigInteger.valueOf(Long.parseLong(hoja.getCell(5, fila).getContents())));
            nuevoContrato.setNumerocompromisosiifcontrato(Integer.parseInt(hoja.getCell(6, fila).getContents()));
            nuevoContrato.setFormapagocontrato(hoja.getCell(7, fila).getContents());
            nuevoContrato.setNumerocuentacontrato(BigInteger.valueOf(Long.parseLong(hoja.getCell(8, fila).getContents())));
            nuevoContrato.setTipocuentacontrato(hoja.getCell(9, fila).getContents());
            nuevoContrato.setClasepersonacontrato(hoja.getCell(10, fila).getContents());

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
   
}
