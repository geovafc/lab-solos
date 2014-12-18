/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.dao.ProprietarioDAO;
import br.edu.ufra.solos.dao.SolicitacaoDAO;
import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.entidade.Solicitacao;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dedo
 */
@ManagedBean
@ViewScoped
public class SolicitacaoConsultaBean implements Serializable {

    private final ProprietarioDAO daoP = new ProprietarioDAO();
    private final SolicitacaoDAO dao = new SolicitacaoDAO();

    private List<Solicitacao> solicitacoes;
    private Solicitacao solicitacao = new Solicitacao();
    private Date entradaInicio;
    private Date entradaFim;
    private Date saidaInicio;
    private Date saidaFim;

    private Integer level = 1;

    public List<Proprietario> autoComplete(String nome) {
        return daoP.obterPorNomeComo(nome);
    }

    public List<Solicitacao> getSolicitacoes() {
        solicitacoes = dao.filtroSolicitacao(solicitacao.getProprietario(), solicitacao.getProcedenciaDoMaterial(),
                entradaInicio, entradaFim, saidaInicio, saidaFim);
        return solicitacoes;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Date getEntradaInicio() {
        return entradaInicio;
    }

    public void setEntradaInicio(Date entradaInicio) {
        this.entradaInicio = entradaInicio;
    }

    public Date getEntradaFim() {
        return entradaFim;
    }

    public void setEntradaFim(Date entradaFim) {
        this.entradaFim = entradaFim;
    }

    public Date getSaidaInicio() {
        return saidaInicio;
    }

    public void setSaidaInicio(Date saidaInicio) {
        this.saidaInicio = saidaInicio;
    }

    public Date getSaidaFim() {
        return saidaFim;
    }

    public void setSaidaFim(Date saidaFim) {
        this.saidaFim = saidaFim;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
