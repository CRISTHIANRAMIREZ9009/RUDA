/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Guarda;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface GuardaFacadeLocal {

    void create(Guarda guarda);

    void edit(Guarda guarda);

    void remove(Guarda guarda);

    Guarda find(Object id);

    List<Guarda> findAll();

    List<Guarda> findRange(int[] range);

    int count();
    
}
