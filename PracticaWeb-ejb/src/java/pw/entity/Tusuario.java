/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Tusuario.findByAdministrador", query = "SELECT t FROM Tusuario t WHERE t.administrador = :administrador"),
    @NamedQuery(name = "Tusuario.findByBloqueado", query = "SELECT t FROM Tusuario t WHERE t.bloqueado = :bloqueado")})
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
    @Column(name = "BLOQUEADO")
    private Character bloqueado;
    @JoinTable(name = "AMIGOS", joinColumns = {
        @JoinColumn(name = "TUSUARIO_ID_USER", referencedColumnName = "ID_USER")}, inverseJoinColumns = {
        @JoinColumn(name = "TUSUARIO_ID_USER1", referencedColumnName = "ID_USER")})
    @ManyToMany
    private List<Tusuario> tusuarioList;
    @ManyToMany(mappedBy = "tusuarioList")
    private List<Tusuario> tusuarioList1;
    @JoinColumn(name = "TGRUPO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tgrupo tgrupoId;

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

    public Character getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Character bloqueado) {
        this.bloqueado = bloqueado;
    }

    @XmlTransient
    public List<Tusuario> getTusuarioList() {
        return tusuarioList;
    }

    public void setTusuarioList(List<Tusuario> tusuarioList) {
        this.tusuarioList = tusuarioList;
    }

    @XmlTransient
    public List<Tusuario> getTusuarioList1() {
        return tusuarioList1;
    }

    public void setTusuarioList1(List<Tusuario> tusuarioList1) {
        this.tusuarioList1 = tusuarioList1;
    }

    public Tgrupo getTgrupoId() {
        return tgrupoId;
    }

    public void setTgrupoId(Tgrupo tgrupoId) {
        this.tgrupoId = tgrupoId;
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
