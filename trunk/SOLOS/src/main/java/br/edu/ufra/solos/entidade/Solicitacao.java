/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import br.edu.ufra.solos.dao.service.EntityBase;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bpmlab
 */
@Entity
@Table(name = "solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id"),
    @NamedQuery(name = "Solicitacao.findByDataDeEntrada", query = "SELECT s FROM Solicitacao s WHERE s.dataDeEntrada = :dataDeEntrada"),
    @NamedQuery(name = "Solicitacao.findByDataDeSaida", query = "SELECT s FROM Solicitacao s WHERE s.dataDeSaida = :dataDeSaida"),
    @NamedQuery(name = "Solicitacao.findByProcedenciaDoMaterial", query = "SELECT s FROM Solicitacao s WHERE s.procedenciaDoMaterial = :procedenciaDoMaterial")})
public class Solicitacao implements EntityBase<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_de_entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeEntrada;
    @Column(name = "data_de_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeSaida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "procedencia_do_material")
    private String procedenciaDoMaterial;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "proprietario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proprietario proprietario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitacao")
    private List<Amostra> amostraList;

    public Solicitacao() {
    }

    public Solicitacao(Integer id) {
        this.id = id;
    }

    public Solicitacao(Integer id, String procedenciaDoMaterial) {
        this.id = id;
        this.procedenciaDoMaterial = procedenciaDoMaterial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Date dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public Date getDataDeSaida() {
        return dataDeSaida;
    }

    public void setDataDeSaida(Date dataDeSaida) {
        this.dataDeSaida = dataDeSaida;
    }

    public String getProcedenciaDoMaterial() {
        return procedenciaDoMaterial;
    }

    public void setProcedenciaDoMaterial(String procedenciaDoMaterial) {
        this.procedenciaDoMaterial = procedenciaDoMaterial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
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
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Solicitacao[ id=" + id + " ]";
    }
    
}
