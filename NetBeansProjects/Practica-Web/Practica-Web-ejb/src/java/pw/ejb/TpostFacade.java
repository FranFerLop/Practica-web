/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pw.entity.Tpost;
import pw.entity.Tusuario;

/**
 *
 * @author Sergio
 */
@Stateless
public class TpostFacade extends AbstractFacade<Tpost> {
    @PersistenceContext(unitName = "Practica-Web-ejbPU")
    private EntityManager em;
    private int identificador=0;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TpostFacade() {
        super(Tpost.class);
    }
    
    public void insertarPostByIdUsuario(String id_usuario,String texto,String imagen){
        Query q;
        Tusuario u;
        q = em.createQuery("SELECT u FROM Tusuario u WHERE u.idUser = :ID"); 
        q.setParameter("ID", id_usuario);
        u = (Tusuario)q.getSingleResult();
        
        Tpost p = new Tpost();
        p.setId(BigDecimal.valueOf(identificador));
        identificador++;
        p.setIdUsuario(u);
        p.setTexto(texto);
        p.setImagen(imagen);
        
    }
    
    public List<Tpost> findPostByIdUsuario(String id){
        Query q;
        List<Tpost> listaPost;
        
        q = em.createQuery("SELECT p FROM Tpost p WHERE p.idUsuario= :ID");
        q.setParameter("ID", id);
        listaPost = q.getResultList();
        
        return listaPost;
    }
}
