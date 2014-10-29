/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean;

import br.edu.ufra.solos.entidade.Usuario;
import br.edu.ufra.solos.util.JsfUtil;
import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.rn.UsuarioRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class UsuarioBean implements Serializable {

    private final UsuarioRN rn = new UsuarioRN();
    private List<Usuario> usuarios;
    private Usuario usuario = new Usuario();

    public String salvar() {
        try {
            rn.salvar(usuario);
            JsfUtil.mensagemSalvoComSucesso();
            return "lista_usuario";
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
            return null;
        }
    }

    public void remover() {
        try {
            rn.remover(usuario);
            JsfUtil.mensagemExcluidoComSucesso();
        } catch (DAOException ex) {
            JsfUtil.mensagemDeErro();
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
