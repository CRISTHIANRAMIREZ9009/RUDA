/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Clausula;


/**
 *
 * @author Cristian®
 */
@Local
public interface ClausulaLogicaLocal {
    
    void create (Clausula clausula) throws Exception;
    void edit (Clausula clausula) throws Exception;
    void remove (Clausula clausula) throws Exception;
    List<Clausula> findAll () throws Exception;
    public String importarDatosClausula (String archivo) throws Exception;
    Clausula find (Integer numeroclausula) throws Exception;
    public void generarReporteClausula(String url) throws Exception;
}
