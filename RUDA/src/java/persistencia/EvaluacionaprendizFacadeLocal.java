/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Evaluacionaprendiz;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface EvaluacionaprendizFacadeLocal {

    void create(Evaluacionaprendiz evaluacionaprendiz);

    void edit(Evaluacionaprendiz evaluacionaprendiz);

    void remove(Evaluacionaprendiz evaluacionaprendiz);

    Evaluacionaprendiz find(Object id);

    List<Evaluacionaprendiz> findAll();

    List<Evaluacionaprendiz> findRange(int[] range);

    int count();
    
}
