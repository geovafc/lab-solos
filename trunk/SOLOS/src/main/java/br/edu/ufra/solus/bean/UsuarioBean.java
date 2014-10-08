/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.bean;

import br.edu.ufra.solos.entidade.Usuario;
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

@RequestScoped
@ManagedBean
public class UsuarioBean implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(UsuarioBean.class.getName());
    private final GenericRN<Usuario> rn = RNFactory.criarUsuarioRN();
    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();

    public UsuarioBean() {

    }

    public String salvar() {
        try {
            rn.salvar(usuario);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
            return "lista_usuario";
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao salvar", ex);
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(usuario);
            JsfUtil.mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
        } catch (DAOException ex) {
            JsfUtil.mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
            LOG.log(Level.SEVERE, "Erro ao remover", ex);
        }
    }

    public List<Usuario> getUsuarios() {
        usuarios = rn.obterTodos();
        return usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
