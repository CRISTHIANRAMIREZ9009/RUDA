/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Monitor;

/**
 *
 * @author TUL-00041FCLEM
 */
@Local
public interface MonitorFacadeLocal {

    void create(Monitor monitor);

    void edit(Monitor monitor);

    void remove(Monitor monitor);

    Monitor find(Object id);

    List<Monitor> findAll();

    List<Monitor> findRange(int[] range);

    int count();
    
}
