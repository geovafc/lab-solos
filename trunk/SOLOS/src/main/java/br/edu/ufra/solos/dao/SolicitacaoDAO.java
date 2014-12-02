/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author bpmlab
 */
public class SolicitacaoDAO extends GenericDAOImpl<SolicitacaoDAO> {

    public SolicitacaoDAO(Class<SolicitacaoDAO> clazz) {
        super(clazz);
    }
   
    public List obterTotalPorAnalise() {
        String jpql = "select f.analise.nome, sum(f.preco) from Faturamento f "
                + "where f.analise in (select a from Analise a where a.solicitacao = :solicitacao)";
        TypedQuery query = getEntityManager().createQuery(jpql, null);
        return null;
    }
}
