/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solus.dao;

import br.edu.ufra.solos.dao.service.DAOFactory;
import br.edu.ufra.solos.dao.service.EntityBase;
import br.edu.ufra.solos.dao.service.GenericDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author bpmlab
 * @param <T>
 */
public class GenericDAOImpl<T extends EntityBase<?>> implements GenericDAO<T> {

    private final EntityManager em = DAOFactory.criarEntityManager();

    @Override
    public void salvar(T entidade) throws DAOException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (entidade.getId() == null) {
                em.persist(entidade);
            } else {
                em.merge(entidade);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new DAOException();
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
            throw new DAOException();
        }
    }

    @Override
    public T obter(Class<T> clazz, Object id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> obterTodos(Class<T> clazz) {
        TypedQuery<T> query = em.createQuery(clazz.getSimpleName() + ".findAll", clazz);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
