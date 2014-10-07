/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.bean;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solus.dao.DAOException;
import br.edu.ufra.solus.rn.RNFactory;
import br.edu.ufra.solus.rn.service.GenericRN;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author bpmlab
 */
@RequestScoped
@ManagedBean
public class ProprietarioBean implements Serializable {

    private final GenericRN<Proprietario> rn = RNFactory.criarGenericRN();
    private List<Proprietario> proprietarios;
    private Proprietario proprietario = new Proprietario();

    public ProprietarioBean() {
    }
    
    public String salvar() {
        try {
            rn.salvar(proprietario);
            return "lista_proprietario";
        } catch (DAOException ex) {
            Logger.getLogger(ProprietarioBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void remover() {
        try {
            rn.remover(proprietario);
        } catch (DAOException ex) {
            Logger.getLogger(ProprietarioBean.class.getName()).log(Level.SEVERE, null, ex);
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
