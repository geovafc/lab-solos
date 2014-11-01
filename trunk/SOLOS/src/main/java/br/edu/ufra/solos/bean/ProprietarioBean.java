/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.entidade.Local;
import br.edu.ufra.solos.rn.ProprietarioRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bpmlab
 */
@RequestScoped
@ManagedBean
public class ProprietarioBean implements Serializable {
    
    private final ProprietarioRN rn = new ProprietarioRN();
    private List<Proprietario> proprietarios;
    private Proprietario proprietario = new Proprietario();
    private boolean enviadoDaSolicitacao = false;

    public ProprietarioBean() {
    }

    public String salvar() {
        try {
            rn.salvar(proprietario);
            JsfUtil.mensagemSalvoComSucesso();
            if (!enviadoDaSolicitacao) {
                return "lista_proprietario";
            } else {
                return "form_solicitacao";
            }
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(proprietario);
            JsfUtil.mensagemSalvoComSucesso();
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
        }
    }

    public List<Proprietario> autoComplete(String busca) {
        return rn.obterPorNomeComo(busca);
    }
    
    public List<Proprietario> getProprietarios() {
        proprietarios = rn.obterTodos();
        return proprietarios;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public boolean getEnviadoDaSolicitacao() {
        return enviadoDaSolicitacao;
    }

    public void setEnviadoDaSolicitacao(boolean enviadoDaSolicitacao) {
        this.enviadoDaSolicitacao = enviadoDaSolicitacao;
    }

}
