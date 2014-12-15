/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.entidade.Analise;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dedo
 */
public class AnaliseDAO extends GenericDAOImpl<Analise> {

    public AnaliseDAO() {
        super(Analise.class);
    }
    
    public List<Analise> obterPorTipo(String tipo) {
        TypedQuery<Analise> query = getEntityManager().createNamedQuery("Analise.findByTipo", Analise.class)
                .setParameter("tipo", tipo);
        return query.getResultList();
    }
    
}
