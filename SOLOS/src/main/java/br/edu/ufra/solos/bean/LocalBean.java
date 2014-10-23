/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Local;
import br.edu.ufra.solos.rn.RNFactory;
import br.edu.ufra.solos.rn.GenericRN;
import br.edu.ufra.solos.util.JsfUtil;
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
@ManagedBean
@RequestScoped
public class LocalBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(LocalBean.class.getName());
    private final GenericRN rn = RNFactory.criarLocalRN();
    private Local local = new Local();
    private List<Local> locais;

    public String salvar() {
        try {
            rn.salvar(local);
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
            rn.remover(local);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
        } catch (Exception e) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao remover", e);
        }
    }
    
    public List<Local> getLocais() {
        locais = rn.obterTodos();
        return locais;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

}
