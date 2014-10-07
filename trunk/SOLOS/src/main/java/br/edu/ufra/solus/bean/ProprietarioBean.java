/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.bean;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.rn.RNFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bpmlab
 */
@RequestScoped
@ManagedBean
public class ProprietarioBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProprietarioBean.class.getName());
    private final GenericRN<Proprietario> rn = RNFactory.criarProprietarioRN();
    private List<Proprietario> proprietarios;
    private Proprietario proprietario = new Proprietario();

    public ProprietarioBean() {
    }

    public String salvar() {
        try {
            rn.salvar(proprietario);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            return "lista_proprietario";
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao salvar", ex);
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(proprietario);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao remover", ex);
        }
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

}
