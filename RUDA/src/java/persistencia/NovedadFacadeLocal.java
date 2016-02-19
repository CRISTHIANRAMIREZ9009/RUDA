/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Novedad;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface NovedadFacadeLocal {

    void create(Novedad novedad);

    void edit(Novedad novedad);

    void remove(Novedad novedad);

    Novedad find(Object id);

    List<Novedad> findAll();

    List<Novedad> findRange(int[] range);

    int count();
    
}
