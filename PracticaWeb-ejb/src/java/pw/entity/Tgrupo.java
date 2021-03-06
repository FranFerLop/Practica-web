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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TGRUPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tgrupo.findAll", query = "SELECT t FROM Tgrupo t"),
    @NamedQuery(name = "Tgrupo.findById", query = "SELECT t FROM Tgrupo t WHERE t.id = :id"),
    @NamedQuery(name = "Tgrupo.findByNombre", query = "SELECT t FROM Tgrupo t WHERE t.nombre = :nombre")})
public class Tgrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE) 
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tgrupoId")
    private List<Tusuario> tusuarioList;

    public Tgrupo() {
    }

    public Tgrupo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Tusuario> getTusuarioList() {
        return tusuarioList;
    }

    public void setTusuarioList(List<Tusuario> tusuarioList) {
        this.tusuarioList = tusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tgrupo)) {
            return false;
        }
        Tgrupo other = (Tgrupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pw.entity.Tgrupo[ id=" + id + " ]";
    }
    
}
