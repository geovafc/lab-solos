/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.bean.converter;

import br.edu.ufra.solos.entidade.EntityBase;
import br.edu.ufra.solos.rn.GenericRN;
import br.edu.ufra.solos.rn.RNFactory;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Dedo
 * @param <T>
 */
public class GenericConverter<T extends EntityBase<?>> implements Converter {

    private final GenericRN<T> rn;

    public GenericConverter(Class<T> clazz) {
        this.rn = RNFactory.criarGenericRN(clazz);
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || "".equals(string)) {
            return null;
        } else {
            try {
                Integer id = new Integer(string);
                return rn.obter(id);
            } catch (Exception e) {
                return null;
            }
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        } else {
            Object id = ((T) o).getId();
            if (id == null) {
                return null;
            } else {
                return id.toString();
            }
        }
    }

}
