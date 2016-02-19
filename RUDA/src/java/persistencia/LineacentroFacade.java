/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Lineacentro;

/**
 *
 * @author TUL-00041FCLEM
 */
@Stateless
public class LineacentroFacade extends AbstractFacade<Lineacentro> implements LineacentroFacadeLocal {
    @PersistenceContext(unitName = "RUDAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineacentroFacade() {
        super(Lineacentro.class);
    }
    
}
