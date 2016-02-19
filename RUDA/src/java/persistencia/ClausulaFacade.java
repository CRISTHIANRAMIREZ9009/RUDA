/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Clausula;

/**
 *
 * @author TUL-00041FCLEM
 */
@Stateless
public class ClausulaFacade extends AbstractFacade<Clausula> implements ClausulaFacadeLocal {
    @PersistenceContext(unitName = "RUDAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClausulaFacade() {
        super(Clausula.class);
    }
    
}
