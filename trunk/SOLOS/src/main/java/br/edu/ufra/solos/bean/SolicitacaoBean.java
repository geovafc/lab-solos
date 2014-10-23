/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Solicitacao;
import br.edu.ufra.solos.rn.RNFactory;
import br.edu.ufra.solos.rn.GenericRN;
import br.edu.ufra.solos.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author bpmlab
 */
@ManagedBean
@ViewScoped
public class SolicitacaoBean implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(SolicitacaoBean.class.getName());
    private final GenericRN rn = RNFactory.criarSolicitacaoRN();
    private Solicitacao solicitacao = new Solicitacao();
    private List<Solicitacao> solicitacoes;

    public String salvar() {
        try {
            rn.salvar(solicitacao);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            return "lista_local";
        } catch (Exception e) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao salvar", e);
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(solicitacao);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
        } catch (Exception e) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao remover", e);
        }
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
    
}
