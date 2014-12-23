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
import br.edu.ufra.solos.entidade.Local;
import br.edu.ufra.solos.entidade.Solicitacao;
import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.rn.SolicitacaoRN;
import br.edu.ufra.solos.util.JsfUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

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
    private final GenericDAO<Local> daoL = DAOFactory.criarGenericDAO(Local.class);

    private Solicitacao solicitacao = new Solicitacao();
    private Amostra amostra = new Amostra();

    private List<Analise> selecionados = new ArrayList<>();
    private List<Local> locais;
    private List<Analise> analises;

    private int quantidade = 1;
    private int level = 1;

    @PostConstruct
    public void init() {
        gerarCodigo();
        solicitacao.setUsuario(daoU.obterTodos().get(0));
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

    public void calcular10DiasUteis() {
        Date date = rn.calcular10DiasUteis(solicitacao.getDataDeEntrada());
        solicitacao.setDataDeSaida(date);
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
            List<Faturamento> lista = rn.montarFaturamento(selecionados, amostra);
            amostra.setFaturamentoList(lista);
            amostra.setSolicitacao(solicitacao);
            solicitacao.getAmostraList().add(amostra);
            rn.salvarNoContexto(amostra);
        for (int i = 1; i < quantidade; i++) {
            reaproveitarAmostra(amostra);
            solicitacao.getAmostraList().add(amostra);
            rn.salvarNoContexto(amostra);
        }
        amostra = new Amostra();
        selecionados = new ArrayList<>();
        gerarCodigo();
    }

    public void removerAmostra() {
        solicitacao.getAmostraList().removeIf((Amostra t) -> t.getCodigo().equals(amostra.getCodigo()));
        rn.removerDoContexto(amostra);
        amostra = new Amostra();
        gerarCodigo();
    }

    public void reaproveitarAmostra(Amostra amostra) {
        this.amostra = rn.reaproveitarAmostra(amostra);
        selecionados.clear();
        for (Faturamento f : amostra.getFaturamentoList()) {
            selecionados.add(f.getAnalise());
        }
    }

    public List<Local> getLocais() {
        if (locais == null) {
            locais = daoL.obterTodos();
        }
        return locais;
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

    public List<Analise> getSelecionados() {
        return selecionados;
    }

    public List<Analise> getAnalises() {
        analises = rn.filtrarPorTipoDeAmostra(daoA.obterTodos(), amostra.getTipo());
        return analises;
    }

    public void setSelecionados(List<Analise> selecionados) {
        this.selecionados = selecionados;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
