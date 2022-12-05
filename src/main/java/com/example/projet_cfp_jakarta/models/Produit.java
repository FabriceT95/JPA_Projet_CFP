package com.example.projet_cfp_jakarta.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produit")
public class Produit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idProduit;

    @Basic
    private String description;

    @Basic
    @Column(nullable = false)
    private float priceHT;

    @Basic
    @Column(nullable = false)
    private float percentageTVA;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Comptabilize> items = new ArrayList<>();

    public Produit() {

    }

    public Produit(Long idProduit, String description, float priceHT, float percentageTVA) {
        this.idProduit = idProduit;
        this.description = description;
        this.priceHT = priceHT;
        this.percentageTVA = percentageTVA;
    }

    public Produit(String description, float priceHT, float percentageTVA) {
        this.description = description;
        this.priceHT = priceHT;
        this.percentageTVA = percentageTVA;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(float priceHT) {
        this.priceHT = priceHT;
    }

    public float getPercentageTVA() {
        return percentageTVA;
    }

    public void setPercentageTVA(float percentageTVA) {
        this.percentageTVA = percentageTVA;
    }
}
