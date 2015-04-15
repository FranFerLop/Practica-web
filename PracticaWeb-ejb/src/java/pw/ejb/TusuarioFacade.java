/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import java.time.Clock;
import java.util.List;
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
        List<Tusuario> lista;
        Tusuario user;
        
        System.out.println(name + " " + pass);
        
        q = em.createQuery("SELECT u FROM Tusuario u WHERE u.nombre = :NAME AND u.password = :PASS");
        q.setParameter("NAME", name);
        q.setParameter("PASS", pass);
       
        lista= (List<Tusuario>)q.getResultList();
        if(!lista.isEmpty()){
            user = lista.get(0);
        }else{
            user = null;
        }
        return user;
        
    }
    
    public List<Tusuario> findAllName(){
        Query q;
        List<Tusuario> lista;
        
        q = em.createQuery("SELECT u FROM Tusuario u");
        lista =(List<Tusuario>)q.getResultList();
        
        if(lista.isEmpty()){
            lista = null;
        }
        
        return lista;
    }

    public Tusuario findByName(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void insertarAmigoByNombre(Tusuario usuario, Tusuario nuevoAmigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
