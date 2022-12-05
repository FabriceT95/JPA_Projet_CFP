package com.example.projet_cfp_jakarta.models;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ComptabilizeId implements Serializable {

    @Column(name="factureId")
    private Long factureId;

    @Column(name="produitId")
    private Long produitId;

    public ComptabilizeId() {

    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }
}
