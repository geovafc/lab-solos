/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean.converter;

import br.edu.ufra.solos.entidade.Local;
import br.edu.ufra.solos.rn.GenericRN;
import br.edu.ufra.solos.rn.RNFactory;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author bpmlab
 */
@FacesConverter(value = "localConverter")
public class LocalConverter implements Converter {

    private final GenericRN<Local> rn = RNFactory.criarLocalRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.isEmpty()) {
            return null;
        } else {
            return rn.obter(new Integer(string));
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        } else {
            Integer id = ((Local) o).getId();
            if (id == null) {
                return null;
            } else {
                return id.toString();
            }
        }
    }

}
