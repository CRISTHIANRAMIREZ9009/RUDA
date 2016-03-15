/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import modelo.Clausula;
import persistencia.ClausulaFacadeLocal;

/**
 *
 * @author Cristian®
 */
@Stateless
public class ClausulaLogica implements ClausulaLogicaLocal {
    
    
    @EJB
    private ClausulaFacadeLocal clausulaDAO;
    
    private int clausulaInsertada;
    private int clausulaExistente;
    
    @Override
    public void create(Clausula clausula) throws Exception {
        
        Clausula nuevaClausula = clausulaDAO.find(clausula.getCodigoclausula());
        
        if(clausula!=null)
        {
            
            if(clausula.getCodigoclausula()== null)
            {
                
                throw new Exception ("!El codigo de la clausula es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!La clausula no tine informaciòn¡");
            
        }
        
        if(nuevaClausula == null)
        {
            
            clausulaDAO.create(clausula);
            
        }
        
        else
        {
            
            throw new Exception ("!La clausula ya esta creada¡");
            
        }
        
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void edit(Clausula clausula) throws Exception {
         Clausula nuevaClausula = clausulaDAO.find(clausula.getCodigoclausula());
        
        if(clausula!=null)
        {
            
            if(clausula.getCodigoclausula()== null)
            {
                
                throw new Exception ("!El codigo de la clausula es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!La clausula no tiene informacion¡");
            
        }
        
        if(nuevaClausula == null)
        {
            
            throw new Exception ("!La clausula no exite y no se puede modificar¡");
            
        }
        
        else
        {
            
            clausulaDAO.edit(clausula);
            
        }
    }

    @Override
    public void remove(Clausula clausula) throws Exception {
       Clausula nuevaClausula = clausulaDAO.find(clausula.getCodigoclausula());
        
        if(clausula!=null)
        {
            
            if(clausula.getCodigoclausula()== null)
            {
                
                throw new Exception ("!El codigo de la clausula es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!La clausula no contiene informacion¡");
            
        }
        
        if(nuevaClausula == null)
        {
            
            throw new Exception ("!La clausula no exite y no se puede eliminar¡");
            
        }
        
        else
        {
            
            clausulaDAO.remove(clausula);
            
        }
    }

    @Override
    public List<Clausula> findAll() throws Exception {
       return clausulaDAO.findAll();
    }

    @Override
    public String importarDatosClausula(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();
        
        clausulaInsertada = 0;
        clausulaExistente = 0;
        
        for (int fila = 1; fila < numFilas; fila++) {
            Clausula nuevaClausula = new Clausula();
            
            nuevaClausula.setCodigoclausula(Integer.parseInt(hoja.getCell(0, fila).getContents()));
            nuevaClausula.setDescripcionclausula(hoja.getCell(1, fila).getContents());
            
            Clausula clausula = clausulaDAO.find(nuevaClausula.getCodigoclausula());
            if (clausula==null) {
                clausulaDAO.create(nuevaClausula);
                clausulaInsertada++;
            }else{
                clausulaExistente++;
            }
            
        }
        return "Se registraron" + clausulaInsertada + "clausula. Ya exisitian " + clausulaExistente + ".";
        
    }

    @Override
    public Clausula find(Integer numeroclausula) throws Exception {
        if(numeroclausula!=null)
        {
            
            return clausulaDAO.find(numeroclausula);
            
        }
        
        else
        {
            
            throw new Exception ("!El codigo de la clausula es obligatorio para la busqueda¡");
            
        }
    }
}
