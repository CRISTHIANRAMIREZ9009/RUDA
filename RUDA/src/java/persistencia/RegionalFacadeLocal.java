/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Regional;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface RegionalFacadeLocal {

    void create(Regional regional);

    void edit(Regional regional);

    void remove(Regional regional);

    Regional find(Object id);

    List<Regional> findAll();

    List<Regional> findRange(int[] range);

    int count();
    
}
