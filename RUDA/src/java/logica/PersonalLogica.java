
package logica;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;
import modelo.Personal;
import org.primefaces.context.RequestContext;
import persistencia.PersonalFacadeLocal;

@Stateless
public class PersonalLogica implements PersonalLogicaLocal {
    
    @EJB
    
    private PersonalFacadeLocal personalDAO;
    
    private int personalInsertado;
    private int personalExistente;

    @Override
    public void create(Personal personal) throws Exception {
        
        Personal nuevoPersonal = personalDAO.find(personal.getDocumentopersonal());
        
        if(personal!=null)
        {
            
            if(personal.getDocumentopersonal() == null)
            {
                
                throw new Exception ("!El documento del personal es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El personal no contiene informacion¡");
            
        }
        
        if(nuevoPersonal == null)
        {
            
            personalDAO.create(personal);
            
        }
        
        else
        {
            
            throw new Exception ("!El personal ya esta creado¡");
            
        }
        
    }

    @Override
    public void edit(Personal personal) throws Exception {
        
        Personal nuevoPersonal = personalDAO.find(personal.getDocumentopersonal());
        
        if(personal!=null)
        {
            
            if(personal.getDocumentopersonal() == null)
            {
                
                throw new Exception ("!El documento del personal es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El personal no contiene informacion¡");
            
        }
        
        if(nuevoPersonal == null)
        {
            
            throw new Exception ("!El personal no existe y no puede ser modificado¡");
            
        }
        
        else
        {
            
            personalDAO.edit(personal);            
            
        }
        
    }

    @Override
    public void remove(Personal personal) throws Exception {
        
        Personal nuevoPersonal = personalDAO.find(personal.getDocumentopersonal());
        
        if(personal!=null)
        {
            
            if(personal.getDocumentopersonal() == null)
            {
                
                throw new Exception ("!El documento del personal es obligatorio¡");
                
            }
            
        }
        
        else
        {
            
            throw new Exception ("!El personal no contiene informacion¡");
            
        }
        
        if(nuevoPersonal == null)
        {
            
            throw new Exception ("!El personal no exite y no se puede eliminar¡");
            
        }
        
        else
        {
            
            personalDAO.remove(personal);
            
        }
        
    }

    @Override
    public Personal find(Long documentopersonal) throws Exception {
        
        if(documentopersonal!=null)
        {
            
            return personalDAO.find(documentopersonal);
            
        }
        
        else
        {
            
            throw new Exception ("!El documento personal es obligatorio para la busqueda¡");
            
        }
        
    }

    @Override
    public List<Personal> findAll() throws Exception {
        return personalDAO.findAll();
    }

    @Override
    public String importarDatosPersonal(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int numFilas = hoja.getRows();

        personalInsertado = 0;
        personalExistente = 0;

        for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
            Personal nuevoPersonal = new Personal();

            nuevoPersonal.setDocumentopersonal(Long.parseLong(hoja.getCell(0, fila).getContents()));
            nuevoPersonal.setNombrepersonal(hoja.getCell(1, fila).getContents());
            nuevoPersonal.setApellidopersonal(hoja.getCell(2, fila).getContents());
            nuevoPersonal.setDireccionpersonal(hoja.getCell(3, fila).getContents());
            nuevoPersonal.setCorreopersonal(hoja.getCell(4, fila).getContents());
            nuevoPersonal.setTelefonopersonal(hoja.getCell(5, fila).getContents());
            nuevoPersonal.setClavepersonal(hoja.getCell(0, fila).getContents());
            nuevoPersonal.setFechanacimientopersonal(Date.valueOf(hoja.getCell(7, fila).getContents()));
            nuevoPersonal.setLugarnacimientopersonal(hoja.getCell(8, fila).getContents());
            nuevoPersonal.setFotopersonal(hoja.getCell(9, fila).getContents());

            Personal personal = personalDAO.find(nuevoPersonal.getDocumentopersonal());
            if (personal == null) {
                personalDAO.create(nuevoPersonal);
                personalInsertado++;
            } else {
                personalExistente++;
            }
        }
        return "!Se registraron " + personalInsertado + " personas. Ya existían " + personalExistente + ".";
    }

    @Override
    public void generarReportePersonal(String url) throws Exception {
        
        String params = "'"
                + url + "/ReportePersonal.do',"
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
