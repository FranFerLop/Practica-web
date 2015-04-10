/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import java.time.Clock;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pw.entity.Tusuario;

/**
 *
 * @author Francisco
 */
@Stateless
public class TusuarioFacade extends AbstractFacade<Tusuario> {
    @PersistenceContext(unitName = "Practica-web-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TusuarioFacade() {
        super(Tusuario.class);
    }
    
    public Tusuario findByNameAndPass(String name,String pass){
        Query q;
        Tusuario user;
        
        System.out.println(name + " " + pass);
        
        q = em.createQuery("SELECT u FROM Tusuario u WHERE u.nombre = :NAME AND u.password = :PASS");
        q.setParameter("NAME", name);
        q.setParameter("PASS", pass);
        
        user = (Tusuario)q.getSingleResult();
        return user;
        
    }
    
}
