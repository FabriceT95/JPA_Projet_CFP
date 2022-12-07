package com.example.projet_cfp_jakarta.dao;

import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Facture;
import com.example.projet_cfp_jakarta.models.Produit;
import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ProduitDao implements Dao<Produit> {
    @Override
    public Optional<Produit> get(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        Optional<Produit> produit = Optional.of(em.find(Produit.class, id));
        em.close();
        return produit;

    }

    @Override
    public List<Produit> getAll() {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Produit> query = em.createQuery("select p from Produit p", Produit.class);
        List<Produit> produits = query.getResultList();
        em.close();
        return produits;
    }

    @Override
    public Produit save(Produit produit) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(produit);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return produit;
    }

    @Override
    public Produit update(Produit produit) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Produit produitToUpdate = Optional.of(em.find(Produit.class, produit.getIdProduit())).get();
            produitToUpdate.setName(produit.getName());
            produitToUpdate.setDescription(produit.getDescription());
            produitToUpdate.setPercentageTVA(produit.getPercentageTVA());
            produitToUpdate.setPriceHT(produit.getPriceHT());
            produitToUpdate.setItems(produit.getItems());
            em.persist(produitToUpdate);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return produit;
    }

    @Override
    public boolean delete(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Optional<Produit> game =  Optional.of(em.find(Produit.class, id));
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
