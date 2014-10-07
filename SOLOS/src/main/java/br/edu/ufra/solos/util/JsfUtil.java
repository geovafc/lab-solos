/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.util;

import java.io.Serializable;
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
}
