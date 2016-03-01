
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
import persistencia.PersonalFacadeLocal;

@Stateless
public class PersonalLogica implements PersonalLogicaLocal {
    
    @EJB
    
    private PersonalFacadeLocal personalDAO;
    
    private int personalInsertado;
    private int personalExistente;

    @Override
    public void create(Personal personal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Personal personal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Personal personal) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String importarDatosPersonal(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        //Recorrer las filas de la primera hoja
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
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            nuevoPersonal.setFechanacimientopersonal(formatoFecha.parse(hoja.getCell(7, fila).getContents()));
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
}
