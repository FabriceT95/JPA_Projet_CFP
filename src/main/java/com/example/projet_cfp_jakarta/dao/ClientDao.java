package com.example.projet_cfp_jakarta.dao;

import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.utils.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Client> {
    @Override
    public Optional<Client> get(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        return Optional.of(em.find(Client.class, id));

    }

    @Override
    public List<Client> getAll() {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Client> query = em.createQuery("select g from Client g", Client.class);
        List<Client> clients = query.getResultList();
        em.close();
        return clients;
    }

    @Override
    public Client save(Client client) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(client);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return client;
    }

    @Override
    public Client update(Client client) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Client clientToUpdate = Optional.of(em.find(Client.class, client.getIdClient())).get();
            clientToUpdate.setName(client.getName());
         //   gameToUpdate.setDescription(game.getDescription());
            em.persist(clientToUpdate);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return client;
    }

    @Override
    public boolean delete(Long id) {
        EntityManagerFactory emf = PersistenceManager.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Optional<Client> game =  Optional.of(em.find(Client.class, id));
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
