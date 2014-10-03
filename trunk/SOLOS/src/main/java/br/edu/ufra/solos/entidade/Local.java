/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import br.edu.ufra.solos.dao.service.EntityBase;
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
    @NamedQuery(name = "Local.findByArea", query = "SELECT l FROM Local l WHERE l.area = :area"),
    @NamedQuery(name = "Local.findByRelevo", query = "SELECT l FROM Local l WHERE l.relevo = :relevo"),
    @NamedQuery(name = "Local.findByPosicaoDoRelevo", query = "SELECT l FROM Local l WHERE l.posicaoDoRelevo = :posicaoDoRelevo"),
    @NamedQuery(name = "Local.findByTipoDeCobertura", query = "SELECT l FROM Local l WHERE l.tipoDeCobertura = :tipoDeCobertura")})
public class Local implements EntityBase<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "area", length = 20)
    private String area;
    @Column(name = "relevo", length = 20)
    private String relevo;
    @Column(name = "posicao_do_relevo", length = 20)
    private String posicaoDoRelevo;
    @Column(name = "tipo_de_cobertura", length = 20)
    private String tipoDeCobertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local")
    private List<Amostra> amostraList;

    public Local() {
    }

    public Local(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRelevo() {
        return relevo;
    }

    public void setRelevo(String relevo) {
        this.relevo = relevo;
    }

    public String getPosicaoDoRelevo() {
        return posicaoDoRelevo;
    }

    public void setPosicaoDoRelevo(String posicaoDoRelevo) {
        this.posicaoDoRelevo = posicaoDoRelevo;
    }

    public String getTipoDeCobertura() {
        return tipoDeCobertura;
    }

    public void setTipoDeCobertura(String tipoDeCobertura) {
        this.tipoDeCobertura = tipoDeCobertura;
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
