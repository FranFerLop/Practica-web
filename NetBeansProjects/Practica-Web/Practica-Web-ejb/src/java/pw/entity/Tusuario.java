/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "TUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusuario.findAll", query = "SELECT t FROM Tusuario t"),
    @NamedQuery(name = "Tusuario.findByIdUser", query = "SELECT t FROM Tusuario t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "Tusuario.findByNombre", query = "SELECT t FROM Tusuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Tusuario.findByPassword", query = "SELECT t FROM Tusuario t WHERE t.password = :password"),
    @NamedQuery(name = "Tusuario.findByAdministrador", query = "SELECT t FROM Tusuario t WHERE t.administrador = :administrador")})
public class Tusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private BigDecimal idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ADMINISTRADOR")
    private Character administrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Tpost> tpostCollection;
    @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tgrupo idGrupo;

    public Tusuario() {
    }

    public Tusuario(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public Tusuario(BigDecimal idUser, String nombre, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.password = password;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Character administrador) {
        this.administrador = administrador;
    }

    @XmlTransient
    public Collection<Tpost> getTpostCollection() {
        return tpostCollection;
    }

    public void setTpostCollection(Collection<Tpost> tpostCollection) {
        this.tpostCollection = tpostCollection;
    }

    public Tgrupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Tgrupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tusuario)) {
            return false;
        }
        Tusuario other = (Tusuario) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pw.entity.Tusuario[ idUser=" + idUser + " ]";
    }
    
}
