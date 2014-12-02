/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Local;
import br.edu.ufra.solos.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bpmlab
 */
@ManagedBean
@RequestScoped
public class LocalBean implements Serializable {

    private final GenericDAO rn = DAOFactory.criarGenericDAO(Local.class);
    private Local local = new Local();
    private List<Local> locais;

    public String salvar() {
        try {
            rn.salvar(local);
            JsfUtil.mensagemSalvoComSucesso();
            return "lista_local";
        } catch (Exception e) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(local);
            JsfUtil.mensagemExcluidoComSucesso();
        } catch (Exception e) {
            JsfUtil.mensagemDeErro();
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
