package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.dao.ComptabilizeDao;
import com.example.projet_cfp_jakarta.dao.FactureDao;
import com.example.projet_cfp_jakarta.dao.ProduitDao;
import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Comptabilize;
import com.example.projet_cfp_jakarta.models.Facture;
import com.example.projet_cfp_jakarta.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/app/factures/add")
public class addFactureServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDao clientDao = new ClientDao();
        List<Client> clientList = clientDao.getAll();
        req.setAttribute("clientList", clientList);

        ProduitDao produitDao = new ProduitDao();
        List<Produit> produitList = produitDao.getAll();
        req.setAttribute("produitList", produitList);

        req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/add-facture.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idClient = req.getParameter("client");
        String[] idsProduit = req.getParameterValues("produit");
        LocalDate createdAt = LocalDate.now();

        int quantity_1 = 2;
        int quantity_2 = 3;

        Client client = new Client();
        client.setIdClient(Long.parseLong(idClient));

        float priceHT = 0;
        float priceTTC = 0;

        ProduitDao produitDao = new ProduitDao();
        ComptabilizeDao comptabilizeDao = new ComptabilizeDao();

        List<Comptabilize> comptabilizesList = new ArrayList<>();
        List<Produit> produitList = new ArrayList<>();

        for (String s : idsProduit) {
            Produit produit = produitDao.get(Long.valueOf(s)).get();
            produitList.add(produit);
            /*Comptabilize c = new Comptabilize();
            c.setProduit(produit);
            c.setQuantity(2);
            produit.addItem(c);
            comptabilizesList.add(c);*/
            priceHT += produit.getPriceHT();
            priceTTC += produit.getPriceHT() + produit.getPriceHT() * produit.getPercentageTVA();
        }

        Facture facture = new Facture(createdAt, priceHT, priceTTC, client);
        FactureDao factureDao = new FactureDao();


        for(Produit p: produitList) {
            facture.addItem(p, 2);
        }

        Facture f = factureDao.save(facture);

        resp.sendRedirect(req.getContextPath() + "/app/factures");
    }
}
