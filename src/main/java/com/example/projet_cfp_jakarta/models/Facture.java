package com.example.projet_cfp_jakarta.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="facture")
public class Facture {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idFacture;

    @Basic
    @Column(nullable = false)
    private LocalDate createdAt;

    @Basic
    @Column(nullable = false)
    private double priceHT;

    @Basic
    @Column(nullable = false)
    private double priceTTC;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "idClient",nullable = false)
    private Client client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL /*, fetch = FetchType.EAGER*/)
    private List<Comptabilize> items = new ArrayList<>();

    public Facture(Long idFacture, LocalDate createdAt, double priceHT, double priceTTC, Client client) {
        this.idFacture = idFacture;
        this.createdAt = createdAt;
        this.priceHT = priceHT;
        this.priceTTC = priceTTC;
        this.client = client;
    }

    public Facture(LocalDate createdAt, double priceHT, double priceTTC, Client client) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public double getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(double priceHT) {
        this.priceHT = priceHT;
    }

    public double getPriceTTC() {
        return priceTTC;
    }

    public void setPriceTTC(double priceTTC) {
        this.priceTTC = priceTTC;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Comptabilize> getItems() {
        return items;
    }

    public void setItems(List<Comptabilize> items) {
        this.items = items;
    }

   /* @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", createdAt=" + createdAt +
                ", priceHT=" + priceHT +
                ", priceTTC=" + priceTTC +
                ", client=" + client +
                ", items=" + items +
                '}';
    }*/
}
