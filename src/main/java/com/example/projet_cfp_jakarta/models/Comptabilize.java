package com.example.projet_cfp_jakarta.models;


import jakarta.persistence.*;

@Entity(name = "Comptabilize")
@Table(name = "comptabilize")
public class Comptabilize {

    @EmbeddedId
    private ComptabilizeId id;

    @ManyToOne
    @MapsId("idFacture")
    private Facture facture;

    @ManyToOne
    @MapsId("idProduit")
    private Produit produit;

    @Basic
    @Column(nullable = false)
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
