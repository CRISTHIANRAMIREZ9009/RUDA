/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Seguimientop;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface SeguimientopFacadeLocal {

    void create(Seguimientop seguimientop);

    void edit(Seguimientop seguimientop);

    void remove(Seguimientop seguimientop);

    Seguimientop find(Object id);

    List<Seguimientop> findAll();

    List<Seguimientop> findRange(int[] range);

    int count();
    
}
