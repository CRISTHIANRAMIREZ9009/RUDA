/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Lideresficha;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface LideresfichaFacadeLocal {

    void create(Lideresficha lideresficha);

    void edit(Lideresficha lideresficha);

    void remove(Lideresficha lideresficha);

    Lideresficha find(Object id);

    List<Lideresficha> findAll();

    List<Lideresficha> findRange(int[] range);

    int count();
    
}
