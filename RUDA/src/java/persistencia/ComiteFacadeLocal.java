/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Comite;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface ComiteFacadeLocal {

    void create(Comite comite);

    void edit(Comite comite);

    void remove(Comite comite);

    Comite find(Object id);

    List<Comite> findAll();

    List<Comite> findRange(int[] range);

    int count();
    
}
