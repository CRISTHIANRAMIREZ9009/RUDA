/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Coformador;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface CoformadorFacadeLocal {

    void create(Coformador coformador);

    void edit(Coformador coformador);

    void remove(Coformador coformador);

    Coformador find(Object id);

    List<Coformador> findAll();

    List<Coformador> findRange(int[] range);

    int count();
    
}
