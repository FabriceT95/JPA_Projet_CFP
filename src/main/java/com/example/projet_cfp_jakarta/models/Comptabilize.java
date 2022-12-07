package com.example.projet_cfp_jakarta.models;


import jakarta.persistence.*;

@Entity(name = "Comptabilize")
@Table(name = "comptabilize")
public class Comptabilize {

    @EmbeddedId
    private ComptabilizeId id;

    @ManyToOne
    @JoinColumn(name = "fk_facture")
    @MapsId("factureId")
    private Facture facture;

    @ManyToOne
    @JoinColumn(name = "fk_produit")
    @MapsId("produitId")
    private Produit produit;

    @Basic
    @Column(nullable = false)
    private int quantity;

   /* public Comptabilize(Facture facture, Produit produit, int quantity) {
        this.facture = facture;
        this.produit = produit;
        this.quantity = quantity;
        System.out.println(this.facture);
        System.out.println(this.produit);
        this.id = new ComptabilizeId(facture.getIdFacture(), produit.getIdProduit());
    }*/

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

    public ComptabilizeId getId() {
        return id;
    }

    public void setId(ComptabilizeId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comptabilize{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
