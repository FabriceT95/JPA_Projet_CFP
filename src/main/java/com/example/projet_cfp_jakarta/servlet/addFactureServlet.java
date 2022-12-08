package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.dao.ComptabilizeDao;
import com.example.projet_cfp_jakarta.dao.FactureDao;
import com.example.projet_cfp_jakarta.dao.ProduitDao;
import com.example.projet_cfp_jakarta.models.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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

        HashMap<String,Integer> cart = (HashMap<String, Integer>) getServletConfig().getServletContext().getAttribute("cart");

        List cartList = new ArrayList<>();

        if(cart != null) {
            for (Map.Entry<String, Integer> entry : cart.entrySet()) {
                Produit produit = produitDao.get(Long.valueOf(entry.getKey())).get();
                HashMap test = new HashMap<>();
                test.put("produit", produit);
                test.put("quantity", entry.getValue());
                cartList.add(test);
            }
        }

        req.setAttribute("cartList", cartList);


        req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/add-facture.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idClient = req.getParameter("client");
        LocalDate createdAt = LocalDate.now();

        ServletContext application = getServletConfig().getServletContext();
        HashMap<String,Integer> cart = (HashMap<String, Integer>) application.getAttribute("cart");



        ClientDao clientDao = new ClientDao();
        Client client = clientDao.get(Long.valueOf(idClient)).get();


        float priceHT = 0;
        float priceTTC = 0;

        ProduitDao produitDao = new ProduitDao();
        List<Produit> produitList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            Produit produit = produitDao.get(Long.valueOf(entry.getKey())).get();
            produitList.add(produit);
            /*Comptabilize c = new Comptabilize();
            c.setProduit(produit);
            c.setQuantity(2);
            produit.addItem(c);
            comptabilizesList.add(c);*/
            priceHT += (produit.getPriceHT() * entry.getValue());
            priceTTC += (produit.getPriceHT() + produit.getPriceHT() * produit.getPercentageTVA()) * entry.getValue();
        }

        Facture facture = new Facture(createdAt, priceHT, priceTTC, client);
        FactureDao factureDao = new FactureDao();

        Facture tempF = factureDao.save(facture);

        Facture f = factureDao.get(tempF.getIdFacture()).get();

        System.out.println("AIE");
        System.out.println(f);

        ComptabilizeDao comptabilizeDao = new ComptabilizeDao();

        for(Produit p: produitList) {
            Comptabilize c = new Comptabilize();
            c.setId(new ComptabilizeId(f.getIdFacture(), p.getIdProduit()));
            c.setFacture(f);
            c.setProduit(p);
            c.setQuantity(cart.get(p.getIdProduit().toString()));
            Comptabilize createdComp = comptabilizeDao.save(c);
           /* f.getItems().add(createdComp);
            produit.getItems().add(createdComp);*/
            // produitDao.update(produit);

        }

       // factureDao.update(f);



        resp.sendRedirect(req.getContextPath() + "/app/factures");
    }
}
