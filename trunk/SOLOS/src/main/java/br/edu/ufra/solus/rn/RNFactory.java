/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.rn;

import br.edu.ufra.solus.rn.service.GenericRN;

/**
 *
 * @author bpmlab
 */
public class RNFactory {

    public static GenericRN criarGenericRN() {
        return new ProprietarioRN();
    }
}
