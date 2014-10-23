/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bpmlab
 */
@Entity
@Table(name = "faturamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faturamento.findAll", query = "SELECT f FROM Faturamento f"),
    @NamedQuery(name = "Faturamento.findById", query = "SELECT f FROM Faturamento f WHERE f.id = :id"),
    @NamedQuery(name = "Faturamento.findByPreco", query = "SELECT f FROM Faturamento f WHERE f.preco = :preco"),
    @NamedQuery(name = "Faturamento.findByTipoDeDesconto", query = "SELECT f FROM Faturamento f WHERE f.tipoDeDesconto = :tipoDeDesconto"),
    @NamedQuery(name = "Faturamento.findByValorDeDesconto", query = "SELECT f FROM Faturamento f WHERE f.valorDeDesconto = :valorDeDesconto")})
public class Faturamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "tipo_de_desconto")
    private Character tipoDeDesconto;
    @Column(name = "valor_de_desconto")
    private BigDecimal valorDeDesconto;
    @JoinColumn(name = "analise", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Analise analise;
    @JoinColumn(name = "amostra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Amostra amostra;

    public Faturamento() {
    }

    public Faturamento(Integer id) {
        this.id = id;
    }

    public Faturamento(Integer id, BigDecimal preco) {
        this.id = id;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Character getTipoDeDesconto() {
        return tipoDeDesconto;
    }

    public void setTipoDeDesconto(Character tipoDeDesconto) {
        this.tipoDeDesconto = tipoDeDesconto;
    }

    public BigDecimal getValorDeDesconto() {
        return valorDeDesconto;
    }

    public void setValorDeDesconto(BigDecimal valorDeDesconto) {
        this.valorDeDesconto = valorDeDesconto;
    }

    public Analise getAnalise() {
        return analise;
    }

    public void setAnalise(Analise analise) {
        this.analise = analise;
    }

    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
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
        if (!(object instanceof Faturamento)) {
            return false;
        }
        Faturamento other = (Faturamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Faturamento[ id=" + id + " ]";
    }
    
}
