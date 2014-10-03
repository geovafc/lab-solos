/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import br.edu.ufra.solos.dao.service.EntityBase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bpmlab
 */
@Entity
@Table(name = "amostra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amostra.findAll", query = "SELECT a FROM Amostra a"),
    @NamedQuery(name = "Amostra.findById", query = "SELECT a FROM Amostra a WHERE a.id = :id"),
    @NamedQuery(name = "Amostra.findByCodigo", query = "SELECT a FROM Amostra a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Amostra.findByTipo", query = "SELECT a FROM Amostra a WHERE a.tipo = :tipo")})
public class Amostra implements EntityBase<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 10)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "amostra")
    private List<Faturamento> faturamentoList;
    @JoinColumn(name = "local", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Local local;
    @JoinColumn(name = "solicitacao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Solicitacao solicitacao;

    public Amostra() {
    }

    public Amostra(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Faturamento> getFaturamentoList() {
        return faturamentoList;
    }

    public void setFaturamentoList(List<Faturamento> faturamentoList) {
        this.faturamentoList = faturamentoList;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
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
        if (!(object instanceof Amostra)) {
            return false;
        }
        Amostra other = (Amostra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Amostra[ id=" + id + " ]";
    }
    
}
