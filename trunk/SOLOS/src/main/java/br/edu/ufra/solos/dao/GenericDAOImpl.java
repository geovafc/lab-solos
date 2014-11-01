/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import br.edu.ufra.solos.util.Reflexao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {

    private static final Logger LOG = Logger.getLogger(GenericDAOImpl.class.getName());
    
    private final EntityManager em = DAOFactory.criarEntityManager();
    private final Class<T> clazz;

    public GenericDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void salvar(T entidade) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            Object id = Reflexao.obterId(entidade);
            tx.begin();
            if (id == null) {
                em.persist(entidade);
            } else {
                em.merge(entidade);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOG.log(Level.INFO, "Erro ao Salvar!", e);
            throw new DAOException(e);
        }
    }

    @Override
    public void remover(T entidade) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(entidade);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOG.log(Level.INFO, "Erro ao Remover!", e);
            throw new DAOException(e);
        }
    }

    @Override
    public void salvarNoContext(Object entidade) {
        em.persist(entidade);
    }

    @Override
    public void removerDoContext(Object entidade) {
        em.remove(entidade);
    }

    @Override
    public T obter(Object id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> obterTodos() {
        TypedQuery<T> query = em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz);
        System.out.println(clazz.getSimpleName() + ".findAll");
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
