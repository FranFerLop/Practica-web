/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pw.entity.Tusuario;

/**
 *
 * @author Sergio
 */
@Stateless
public class TusuarioFacade extends AbstractFacade<Tusuario> {
    @PersistenceContext(unitName = "Practica-Web-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TusuarioFacade() {
        super(Tusuario.class);
    }

    public void insertarAmigoByNombre(Object attribute, String nuevoAmigo) {
        
        
    }
    
}
