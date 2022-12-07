package com.example.projet_cfp_jakarta.models;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ComptabilizeId implements Serializable {

    private static final long serialVersionUID = -3287715633608041039L;

    private Long factureId;

    private Long produitId;

    public ComptabilizeId() {

    }

    public ComptabilizeId(Long factureId, Long produitId) {
        this.factureId = factureId;
        this.produitId = produitId;
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

    @Override
    public String toString() {
        return "ComptabilizeId{" +
                "factureId=" + factureId +
                ", produitId=" + produitId +
                '}';
    }
}
