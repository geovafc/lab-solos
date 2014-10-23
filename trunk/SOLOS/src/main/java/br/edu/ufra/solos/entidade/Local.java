/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import java.io.Serializable;
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
 * @author bpmlab
 */
@Entity
@Table(name = "local")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findById", query = "SELECT l FROM Local l WHERE l.id = :id"),
    @NamedQuery(name = "Local.findByMunicipio", query = "SELECT l FROM Local l WHERE l.municipio = :municipio"),
    @NamedQuery(name = "Local.findByEstado", query = "SELECT l FROM Local l WHERE l.estado = :estado")})
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<Proprietario> proprietarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<Amostra> amostraList;

    public Local() {
    }

    public Local(Integer id) {
        this.id = id;
    }

    public Local(Integer id, String municipio, String estado) {
        this.id = id;
        this.municipio = municipio;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Proprietario> getProprietarioList() {
        return proprietarioList;
    }

    public void setProprietarioList(List<Proprietario> proprietarioList) {
        this.proprietarioList = proprietarioList;
    }

    @XmlTransient
    public List<Amostra> getAmostraList() {
        return amostraList;
    }

    public void setAmostraList(List<Amostra> amostraList) {
        this.amostraList = amostraList;
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
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Local[ id=" + id + " ]";
    }
    
}
