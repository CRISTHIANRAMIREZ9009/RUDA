
package logica;

import java.io.File;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Personal;

@Stateless
public class PersonalLogica implements PersonalLogicaLocal {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        docentesInsertados = 0;
        docentesExistentes = 0;

        for (int fila = 1; fila < numFilas; fila++) { // Recorre cada 
            Docente nuevoDocente = new Docente();

            nuevoDocente.setDocumentodocente(Long.parseLong(hoja.getCell(0, fila).getContents()));
            nuevoDocente.setNombredocente(hoja.getCell(1, fila).getContents());
            nuevoDocente.setApellidodocente(hoja.getCell(2, fila).getContents());
            nuevoDocente.setCorreodocente(hoja.getCell(3, fila).getContents());
            nuevoDocente.setTelefonodocente(hoja.getCell(4, fila).getContents());
            nuevoDocente.setProfesiondocente(hoja.getCell(5, fila).getContents());
            nuevoDocente.setClavedocente(hoja.getCell(0, fila).getContents());

            Docente d = docenteDAO.find(nuevoDocente.getDocumentodocente());
            if (d == null) {
                docenteDAO.create(nuevoDocente);
                docentesInsertados++;
            } else {
                docentesExistentes++;
            }
        }
        return "Se registraron " + docentesInsertados + " docentes. Ya existían " + docentesExistentes;
    }
}
