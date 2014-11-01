/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dedo
 */
public class Reflexao {
    private static final Logger LOG = Logger.getLogger(Reflexao.class.getName());

    public static Object obterId(Object entidade) {
        try {
            Method getId = entidade.getClass().getMethod("getId", new Class[0]);
            return getId.invoke(entidade, new Object[0]);
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException | IllegalAccessException ex) {
            LOG.log(Level.SEVERE, "Erro de reflexão, não foi possivel acessar o método getId", ex);
            return null;
        }
    }
}
