/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bpmlab
 */
@Entity
@Table(name = "analise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analise.findAll", query = "SELECT a FROM Analise a"),
    @NamedQuery(name = "Analise.findById", query = "SELECT a FROM Analise a WHERE a.id = :id"),
    @NamedQuery(name = "Analise.findByTipo", query = "SELECT a FROM Analise a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Analise.findByNome", query = "SELECT a FROM Analise a WHERE a.nome = :nome"),
    @NamedQuery(name = "Analise.findByPreco", query = "SELECT a FROM Analise a WHERE a.preco = :preco")})
public class Analise implements EntityBase<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tipo", length = 10)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nome", length = 45)
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "preco")
    private BigDecimal preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analise")
    private List<Faturamento> faturamentoList;

    public Analise() {
    }

    public Analise(Integer id) {
        this.id = id;
    }

    public Analise(Integer id, String tipo, String nome, BigDecimal preco) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @XmlTransient
    public List<Faturamento> getFaturamentoList() {
        return faturamentoList;
    }

    public void setFaturamentoList(List<Faturamento> faturamentoList) {
        this.faturamentoList = faturamentoList;
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
        if (!(object instanceof Analise)) {
            return false;
        }
        Analise other = (Analise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Analise[ id=" + id + " ]";
    }
    
}
