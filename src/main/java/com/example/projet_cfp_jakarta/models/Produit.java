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
    @Column(nullable = false)
    private String name;

    @Basic
    private String description;



    @Basic
    @Column(nullable = false)
    private double priceHT;

    @Basic
    @Column(nullable = false)
    private double percentageTVA;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Comptabilize> items = new ArrayList<>();

    public Produit() {

    }

    public Produit(Long idProduit, String name, String description, double priceHT, double percentageTVA) {
        this.idProduit = idProduit;
        this.name = name;
        this.description = description;
        this.priceHT = priceHT;
        this.percentageTVA = percentageTVA;
    }

    public Produit(String name, String description, double priceHT, double percentageTVA) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceHT() {
        return priceHT;
    }

    public void setPriceHT(double priceHT) {
        this.priceHT = priceHT;
    }

    public double getPercentageTVA() {
        return percentageTVA;
    }

    public void setPercentageTVA(double percentageTVA) {
        this.percentageTVA = percentageTVA;
    }

    public void addItem(Comptabilize c) {
        this.items.add(c);
    }

}
