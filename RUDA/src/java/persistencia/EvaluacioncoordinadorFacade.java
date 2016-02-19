/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Evaluacioncoordinador;

/**
 *
 * @author TUL-00041FCLEM
 */
@Stateless
public class EvaluacioncoordinadorFacade extends AbstractFacade<Evaluacioncoordinador> implements EvaluacioncoordinadorFacadeLocal {
    @PersistenceContext(unitName = "RUDAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluacioncoordinadorFacade() {
        super(Evaluacioncoordinador.class);
    }
    
}
