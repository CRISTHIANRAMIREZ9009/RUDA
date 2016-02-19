/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Usodeambientes;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface UsodeambientesFacadeLocal {

    void create(Usodeambientes usodeambientes);

    void edit(Usodeambientes usodeambientes);

    void remove(Usodeambientes usodeambientes);

    Usodeambientes find(Object id);

    List<Usodeambientes> findAll();

    List<Usodeambientes> findRange(int[] range);

    int count();
    
}
