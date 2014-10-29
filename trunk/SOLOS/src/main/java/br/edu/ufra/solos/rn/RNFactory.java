/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

/**
 *
 * @author bpmlab
 */
public class RNFactory {

    public static GenericRN criarGenericRN(Class<?> clazz) {
        return new GenericRNImpl(clazz);
    }
    
}
