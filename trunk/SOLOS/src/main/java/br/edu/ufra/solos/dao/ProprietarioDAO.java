/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.entidade.Proprietario;
import java.util.List;

/**
 *
 * @author bpmlab
 */
public class ProprietarioDAO extends GenericDAOImpl<Proprietario> {

    public ProprietarioDAO() {
        super(Proprietario.class);
    }

    public List<Proprietario> obterPorNomeComo(String nome) {
        nome += "%";
        String jpql = "select p from Proprietario p where p.nome like :nome";
        return getEntityManager()
                .createQuery(jpql, Proprietario.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
