/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pw.entity.Tgrupo;

/**
 *
 * @author Francisco
 */
@Stateless
public class TgrupoFacade extends AbstractFacade<Tgrupo> {
    @PersistenceContext(unitName = "Practica-web-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TgrupoFacade() {
        super(Tgrupo.class);
    }
    
}
