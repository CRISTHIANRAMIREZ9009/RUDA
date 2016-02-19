/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Clausula;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface ClausulaFacadeLocal {

    void create(Clausula clausula);

    void edit(Clausula clausula);

    void remove(Clausula clausula);

    Clausula find(Object id);

    List<Clausula> findAll();

    List<Clausula> findRange(int[] range);

    int count();
    
}
