/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao.service;

import br.edu.ufra.solus.dao.GenericDAOImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bpmlab
 */
public class DAOFactory {

    private static final EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("SOLOS");

    public static EntityManager criarEntityManager() {
        return factory.createEntityManager();
    }
    
    public static GenericDAO criarGenericDAO() {
        return new GenericDAOImpl();
    }
}
