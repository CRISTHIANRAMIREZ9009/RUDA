/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Elementoparticular;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface ElementoparticularFacadeLocal {

    void create(Elementoparticular elementoparticular);

    void edit(Elementoparticular elementoparticular);

    void remove(Elementoparticular elementoparticular);

    Elementoparticular find(Object id);

    List<Elementoparticular> findAll();

    List<Elementoparticular> findRange(int[] range);

    int count();
    
}
