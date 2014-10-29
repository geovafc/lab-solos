/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.rn;

import br.edu.ufra.solos.dao.DAOException;
import br.edu.ufra.solos.dao.DAOFactory;
import br.edu.ufra.solos.dao.GenericDAO;
import br.edu.ufra.solos.entidade.Amostra;
import br.edu.ufra.solos.entidade.Analise;
import br.edu.ufra.solos.entidade.Faturamento;
import br.edu.ufra.solos.entidade.Solicitacao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dedo
 */
public class SolicitacaoRN implements Serializable {

    private final GenericDAO<Solicitacao> dao = DAOFactory.criarGenericDAO(Solicitacao.class);

    public void salvar(Solicitacao entidade) throws DAOException {
        dao.salvar(entidade);
    }

    public void remover(Solicitacao entidade) throws DAOException {
        dao.remover(entidade);
    }

    public void salvarNoContexto(Object object) {
        dao.salvarNoContext(object);
    }

    public void removerDoContexto(Object object) {
        dao.removerDoContext(object);
    }

    public List<Faturamento> montarFaturamento(List<Analise> analises, Amostra amostra) {
        List<Faturamento> lista = new ArrayList<>();
        for (Analise analise : analises) {
            Faturamento f = new Faturamento();
            f.setAmostra(amostra);
            f.setAnalise(analise);
            f.setPreco(analise.getPreco());
            lista.add(f);
        }
        return lista;
    }

    public Solicitacao obter(Object id) {
        return dao.obter(id);
    }

    public List<Solicitacao> obterTodos() {
        return dao.obterTodos();
    }

}
