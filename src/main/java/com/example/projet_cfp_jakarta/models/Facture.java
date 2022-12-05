package com.example.projet_cfp_jakarta.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="facture")
public class Facture {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idFacture;

    @Basic
    @Column(nullable = false)
    private Timestamp createdAt;

    @Basic
    @Column(nullable = false)
    private float priceHT;

    @Basic
    @Column(nullable = false)
    private float priceTTC;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient",nullable = false)
    private Client client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<Comptabilize> items = new ArrayList<>();

    public Facture(Long idFacture, Timestamp createdAt, float priceHT, float priceTTC, Client client) {
        this.idFacture = idFacture;
        this.createdAt = createdAt;
        this.priceHT = priceHT;
        this.priceTTC = priceTTC;
        this.client = client;
    }

    public Facture(Timestamp createdAt, float priceHT, float priceTTC, Client client) {
        this.createdAt = createdAt;
        this.priceHT = priceHT;
        this.priceTTC = priceTTC;
        this.client = client;
    }

    public Facture() {

    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public float getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(float priceHT) {
        this.priceHT = priceHT;
    }

    public float getPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(float priceTTC) {
        this.priceTTC = priceTTC;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
