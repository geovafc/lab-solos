/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.entidade.Proprietario;
import br.edu.ufra.solos.entidade.Solicitacao;
import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author bpmlab
 */
public class SolicitacaoDAO extends GenericDAOImpl<Solicitacao> {

    public SolicitacaoDAO() {
        super(Solicitacao.class);
    }

    public List obterTotalPorAnalise() {
        String jpql = "select f.analise.nome, sum(f.preco) from Faturamento f "
                + "where f.analise in (select a from Analise a where a.solicitacao = :solicitacao)";
        TypedQuery query = getEntityManager().createQuery(jpql, null);
        return null;
    }

    public List<Solicitacao> filtroSolicitacao(Proprietario proprietario, String procedenciaDoMaterial,
            Date entradaInicio, Date entradaFim, Date saidaInicio, Date saidaFim) {
        EasyCriteria<Solicitacao> easyCriteria = EasyCriteriaFactory.createQueryCriteria(getEntityManager(), Solicitacao.class);
        if (proprietario == null && procedenciaDoMaterial == null &&entradaInicio == null && 
                entradaFim == null && saidaInicio == null && saidaFim == null) {
            return Collections.EMPTY_LIST;
        }
        if (proprietario != null) {
            easyCriteria.andEquals("proprietario", proprietario);
        }
        if (procedenciaDoMaterial != null && !procedenciaDoMaterial.equals("")) {
            easyCriteria.andEquals("procedenciaDoMaterial", procedenciaDoMaterial);
        }
        if (entradaInicio != null && entradaFim != null) {
            easyCriteria.andBetween("dataDeEntrada", entradaInicio, entradaFim);
        }
        if (saidaInicio != null && saidaFim != null) {
            easyCriteria.andBetween("dataDeSaida", saidaInicio, saidaFim);
        }
        return easyCriteria.getResultList();
    }

}
