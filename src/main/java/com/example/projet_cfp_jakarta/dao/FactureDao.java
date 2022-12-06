package com.example.projet_cfp_jakarta.dao;

import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Facture;
import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class FactureDao implements Dao<Facture> {
    @Override
    public Optional<Facture> get(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        return Optional.of(em.find(Facture.class, id));

    }

    @Override
    public List<Facture> getAll() {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Facture> query = em.createQuery("select f from Facture f", Facture.class);
        List<Facture> factures = query.getResultList();
        em.close();
        return factures;
    }

    @Override
    public Facture save(Facture facture) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(facture);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return facture;
    }

    @Override
    public Facture update(Facture facture) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Facture factureToUpdate = Optional.of(em.find(Facture.class, facture.getIdFacture())).get();
           // factureToUpdate.setName(client.getName());
            em.persist(factureToUpdate);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return facture;
    }

    @Override
    public boolean delete(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Optional<Facture> game =  Optional.of(em.find(Facture.class, id));
            em.remove(game.get());
            et.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }

        return false;
    }
}
