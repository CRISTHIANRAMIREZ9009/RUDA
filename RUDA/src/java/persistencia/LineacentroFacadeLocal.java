/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Lineacentro;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface LineacentroFacadeLocal {

    void create(Lineacentro lineacentro);

    void edit(Lineacentro lineacentro);

    void remove(Lineacentro lineacentro);

    Lineacentro find(Object id);

    List<Lineacentro> findAll();

    List<Lineacentro> findRange(int[] range);

    int count();
    
}
