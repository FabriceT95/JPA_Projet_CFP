package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.dao.FactureDao;
import com.example.projet_cfp_jakarta.models.Client;
import com.example.projet_cfp_jakarta.models.Facture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/app/factures/delete")
public class DeleteFactureServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idFacture = req.getParameter("idFactureDelete");

        try {
            Long id = Long.parseLong(idFacture);
            FactureDao factureDao = new FactureDao();
            Optional<Facture> facture = factureDao.get(id);
            if(facture.isPresent()) {
                factureDao.delete(id);
            } else {
                System.err.println("Facture not found ! Can't delete it !");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/app/factures");
    }
}
