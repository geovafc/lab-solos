/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.entidade;

import java.io.Serializable;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public interface EntityBase<T> extends Serializable {

    T getId();
}
