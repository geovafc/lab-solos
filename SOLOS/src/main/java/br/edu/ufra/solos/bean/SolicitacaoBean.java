/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Amostra;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.entidade.Faturamento;
import br.edu.ufra.solos.entidade.Solicitacao;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.rn.SolicitacaoRN;
import br.edu.ufra.solos.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author bpmlab
 */
@ManagedBean
@ViewScoped
public class SolicitacaoBean implements Serializable {

    private final SolicitacaoRN rn = new SolicitacaoRN();
    private final GenericDAO<Analise> daoA = DAOFactory.criarGenericDAO(Analise.class);
    private final GenericDAO<Usuario> daoU = DAOFactory.criarGenericDAO(Usuario.class);

    private Solicitacao solicitacao = new Solicitacao();
    private Amostra amostra = new Amostra();

    private DualListModel<Analise> dlmAnalises;
    private List<Solicitacao> solicitacoes;
    private List<Analise> analises;
    
    private int level = 1;

    @PostConstruct
    public void init() {
        gerarCodigo();
        analises = daoA.obterTodos();
        solicitacao.setUsuario(daoU.obterTodos().get(0));
        dlmAnalises = new DualListModel(analises, new ArrayList<>());
    }

    public String handleFlow(FlowEvent event) {
        String newStep = event.getNewStep();
        if (newStep.equals("amostra")) {
            rn.salvarNoContexto(solicitacao);
        }
        return newStep;
    }

    public void gerarCodigo() {
        amostra.setCodigo(rn.gerarCodigo());
    }

    public String salvar() {
        try {
            rn.salvar(solicitacao);
            JsfUtil.mensagemSalvoComSucesso();
            return "index";
        } catch (Exception e) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(solicitacao);
            JsfUtil.mensagemExcluidoComSucesso();
        } catch (Exception e) {
            JsfUtil.mensagemDeErro();
        }
    }

    public void addAmostra() {
        List<Faturamento> lista = rn.montarFaturamento(dlmAnalises.getTarget(), amostra);
        amostra.setFaturamentoList(lista);
        amostra.setSolicitacao(solicitacao);
        solicitacao.getAmostraList().add(amostra);
        rn.salvarNoContexto(amostra);
        amostra = new Amostra();
        gerarCodigo();
    }

    public void removerAmostra() {
        solicitacao.getAmostraList().remove(amostra);
        rn.removerDoContexto(amostra);
        amostra = new Amostra();
        gerarCodigo();
    }

    public DualListModel<Analise> getDlmAnalises() {
        return dlmAnalises;
    }

    public void setDlmAnalises(DualListModel<Analise> dlmAnalises) {
        this.dlmAnalises = dlmAnalises;
    }

    public List<Solicitacao> getSolicitacoes() {
        solicitacoes = rn.obterTodos();
        return solicitacoes;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}