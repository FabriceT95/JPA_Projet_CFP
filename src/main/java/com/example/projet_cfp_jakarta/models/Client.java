package com.example.projet_cfp_jakarta.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="client")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idClient;

    @Basic
    @Column(nullable = false)
    private String name;

    @Basic
    @Column(nullable = false)
    private String address;

    @Basic
    @Column(nullable = false)
    private String postalCode;

    @Basic
    @Column(nullable = false)
    private String city;

    @Basic
    @Column(nullable = false)
    private int phoneNumber;

    @Basic
    @Column(nullable = false)
    private String email;

    @OneToMany(fetch =FetchType.EAGER,targetEntity = Facture.class, mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Collection<Facture> factureList = new ArrayList<>();

    public Client() {}

    public Client(String name, String address, String postalCode, String city, int phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Client(Long idClient, String name, String address, String postalCode, String city, int phoneNumber, String email) {
        this.idClient = idClient;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Facture> getFactureList() {
        return factureList;
    }

    public void addFacture(Facture f) {
        this.factureList.add(f);
    }

   /* @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", factureList=" + factureList +
                '}';
    }*/
}
