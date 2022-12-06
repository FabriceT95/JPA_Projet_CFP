package com.example.projet_cfp_jakarta.dao;


import com.example.projet_cfp_jakarta.models.Comptabilize;
import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class ComptabilizeDao implements Dao<Comptabilize> {

    @Override
    public Optional<Comptabilize> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Comptabilize> getAll() {
        return null;
    }

    @Override
    public Comptabilize save(Comptabilize comptabilize) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(comptabilize);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return comptabilize;
    }

    @Override
    public Comptabilize update(Comptabilize comptabilize) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
