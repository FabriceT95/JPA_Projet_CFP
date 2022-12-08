package com.example.projet_cfp_jakarta.dao;

import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Facture;
import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FactureDao implements Dao<Facture> {
    @Override
    public Optional<Facture> get(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Facture facture = null;
        try {
            TypedQuery<Facture> query = em.createQuery("select f from Facture f left join fetch f.items WHERE f.idFacture=:id", Facture.class);
            query.setParameter("id",id);
            facture = query.getSingleResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return Optional.of(facture);
    }

    @Override
    public List<Facture> getAll() {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        List<Facture> factures = new ArrayList<>();
        try {
            TypedQuery<Facture> query = em.createQuery("select f from Facture f", Facture.class);
            factures = query.getResultList();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }

        return factures;



    }

    @Override
    public Facture save(Facture facture) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
           // if(facture.getIdFacture() != null) {
          //  em.merge(facture);
            //} else {
            em.persist(facture);
           // }
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
            factureToUpdate.setClient(facture.getClient());
            factureToUpdate.setPriceHT(facture.getPriceHT());
            factureToUpdate.setPriceTTC(facture.getPriceTTC());
            factureToUpdate.setItems(facture.getItems());
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
            Optional<Facture> facture =  Optional.of(em.find(Facture.class, id));
            em.remove(facture.get());
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
