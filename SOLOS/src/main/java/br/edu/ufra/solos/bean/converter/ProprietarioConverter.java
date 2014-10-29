/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean.converter;

import br.edu.ufra.solos.dao.ProprietarioDAO;
import br.edu.ufra.solos.entidade.Proprietario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bpmlab
 */
@FacesConverter(value = "proprietarioConverter")
public class ProprietarioConverter implements Converter {

    private final GenericConverter<Proprietario> converter = new GenericConverter<>(Proprietario.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return converter.getAsObject(fc, uic, string);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return converter.getAsString(fc, uic, o);
    }

}
