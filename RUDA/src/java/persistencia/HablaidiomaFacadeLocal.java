/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Hablaidioma;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface HablaidiomaFacadeLocal {

    void create(Hablaidioma hablaidioma);

    void edit(Hablaidioma hablaidioma);

    void remove(Hablaidioma hablaidioma);

    Hablaidioma find(Object id);

    List<Hablaidioma> findAll();

    List<Hablaidioma> findRange(int[] range);

    int count();
    
}
