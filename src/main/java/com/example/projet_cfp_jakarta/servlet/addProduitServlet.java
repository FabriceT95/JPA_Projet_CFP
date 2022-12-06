package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.FactureDao;
import com.example.projet_cfp_jakarta.dao.ProduitDao;
import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Facture;
import com.example.projet_cfp_jakarta.models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/app/produits/add")
public class addProduitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/add-produit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String id = req.getParameter("produitId");
        String name = req.getParameter("produitName");
        String description = req.getParameter("produitDescription");
        double pourcentageTVA = Double.parseDouble(req.getParameter("produitPourcentageTVA"));
        double priceHT = Double.parseDouble(req.getParameter("produitPriceHT"));


        Produit produit = new Produit(name, description, priceHT, pourcentageTVA);

        ProduitDao produitDao = new ProduitDao();

        produitDao.save(produit);



        resp.sendRedirect(req.getContextPath() + "/app/factures");
    }
}
