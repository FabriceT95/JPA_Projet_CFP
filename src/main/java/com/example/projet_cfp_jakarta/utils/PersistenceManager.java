package com.example.projet_cfp_jakarta.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class PersistenceManager {
    private static EntityManagerFactory CONNECTION_INSTANCE;

    private final static String persistenceUnitName = "cfp_pu";

    private PersistenceManager(){

    }

    public static EntityManagerFactory getEntityManagerFactory() {

        if(CONNECTION_INSTANCE == null || !CONNECTION_INSTANCE.isOpen()) {
            CONNECTION_INSTANCE = Persistence.createEntityManagerFactory(persistenceUnitName);
        }

        return CONNECTION_INSTANCE;
    }


    public static void closeConnection() {
        try {
            CONNECTION_INSTANCE.close();
        } catch (Exception e) {
            System.err.println("Fermeture de la connexion impossible");
        }
    }
}
