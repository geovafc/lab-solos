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

    public static GenericRN criarProprietarioRN() {
        return new ProprietarioRN();
    }

    public static GenericRN criarAnaliseRN() {
        return new AnaliseRN();
    }

    public static GenericRN criarUsuarioRN() {
        return new UsuarioRN();
    }

    public static GenericRN criarLocalRN() {
        return new LocalRN();
    }

    public static GenericRN criarSolicitacaoRN() {
        return new SolicitacaoRN();
    }
}
