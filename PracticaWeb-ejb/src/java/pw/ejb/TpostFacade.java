/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pw.entity.*;

/**
 *
 * @author Francisco
 */
@Stateless
public class TpostFacade extends AbstractFacade<Tpost> {
    @PersistenceContext(unitName = "Practica-web-ejbPU")
    private EntityManager em;   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TpostFacade() {
        super(Tpost.class);
    }
    public Tpost insertarPostByUsuario(Tusuario usuario,List<Tpost> lista,String texto,String imagen){
        BigDecimal identificador;
        
        if(lista.isEmpty()){
            identificador = BigDecimal.valueOf(1);
        }else{
            identificador = BigDecimal.valueOf(lista.size()+1);
        }
        
        Tpost p = new Tpost(identificador);
        p.setTexto(texto);
        p.setImagen(imagen);
        p.setTusuarioIdUser(usuario);
        
        em.persist(p);
        
        return p;
    }
    
    public List<Tpost> findListPostByIdUsuario(BigDecimal id){
        Query q;
        List<Tpost> listaPost;
        
        q = em.createQuery("SELECT p FROM Tpost p WHERE p.tusuarioIdUser.idUser = :ID");
        q.setParameter("ID", id);
        listaPost = (List<Tpost>)q.getResultList();
        
        return listaPost;
    }
}


