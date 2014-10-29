/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.util;

import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 *
 * @author bpmlab
 */
public class JsfUtil implements Serializable {
    
    public static void mensagem(Severity severity, String summary, String detail) {
        FacesMessage fm = new FacesMessage(severity, summary, detail);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, fm);
    }
    
    public static void mensagemSalvoComSucesso() {
        mensagem(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", "");
    }
    
    public static void mensagemExcluidoComSucesso() {
        mensagem(FacesMessage.SEVERITY_INFO, "Excluído com sucesso!", "");
    }
    
    public static void mensagemDeErro() {
        mensagem(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado!", "");
    }
    
    public static void colocarNaSessao(String key, Object value) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> map = facesContext.getExternalContext().getSessionMap();
        map.put(key, value);
    }
    
    public static Object obterDaSessao(String key) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> map = facesContext.getExternalContext().getSessionMap();
        return map.get(key);
    }
}
