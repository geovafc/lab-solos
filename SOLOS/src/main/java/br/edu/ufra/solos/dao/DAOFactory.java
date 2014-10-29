/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufra.solos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bpmlab
 */
public class DAOFactory {

    private static final EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("br.edu.ufra_SOLOS_war_1.0-SNAPSHOTPU");

    public static EntityManagerFactory getFactory() {
        return factory;
    }

    public static EntityManager criarEntityManager() {
        return factory.createEntityManager();
    }
    
    public static GenericDAO criarGenericDAO(Class<?> clazz) {
        return new GenericDAOImpl(clazz);
    }

    public static void main(String[] args) {
        factory.close();
    }
}
