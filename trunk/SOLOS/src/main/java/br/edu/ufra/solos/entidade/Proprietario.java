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
@Table(name = "proprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proprietario.findAll", query = "SELECT p FROM Proprietario p"),
    @NamedQuery(name = "Proprietario.findById", query = "SELECT p FROM Proprietario p WHERE p.id = :id"),
    @NamedQuery(name = "Proprietario.findByNome", query = "SELECT p FROM Proprietario p WHERE p.nome = :nome"),
    @NamedQuery(name = "Proprietario.findByMunicipio", query = "SELECT p FROM Proprietario p WHERE p.municipio = :municipio"),
    @NamedQuery(name = "Proprietario.findByEstado", query = "SELECT p FROM Proprietario p WHERE p.estado = :estado"),
    @NamedQuery(name = "Proprietario.findByEmail", query = "SELECT p FROM Proprietario p WHERE p.email = :email"),
    @NamedQuery(name = "Proprietario.findByTelefone", query = "SELECT p FROM Proprietario p WHERE p.telefone = :telefone")})
public class Proprietario implements EntityBase<Integer> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(name = "municipio", length = 45)
    private String municipio;
    @Basic(optional = false)
    @Column(name = "estado", length = 2)
    private String estado;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email", length = 45)
    private String email;
    @Basic(optional = false)
    @Column(name = "telefone", length = 20)
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietario")
    private List<Solicitacao> solicitacaoList;

    public Proprietario() {
    }

    public Proprietario(Integer id) {
        this.id = id;
    }

    public Proprietario(Integer id, String nome, String municipio, String estado, String telefone) {
        this.id = id;
        this.nome = nome;
        this.municipio = municipio;
        this.estado = estado;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<Solicitacao> getSolicitacaoList() {
        return solicitacaoList;
    }

    public void setSolicitacaoList(List<Solicitacao> solicitacaoList) {
        this.solicitacaoList = solicitacaoList;
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
        if (!(object instanceof Proprietario)) {
            return false;
        }
        Proprietario other = (Proprietario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.solos.entidade.Proprietario[ id=" + id + " ]";
    }
    
}
