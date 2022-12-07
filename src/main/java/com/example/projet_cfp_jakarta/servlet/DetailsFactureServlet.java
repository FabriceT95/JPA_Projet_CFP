package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.FactureDao;
import com.example.projet_cfp_jakarta.models.Facture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/app/factures/details")
public class DetailsFactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        FactureDao factureDao = new FactureDao();
        Optional<Facture> facture = factureDao.get(Long.valueOf(id));
        req.setAttribute("facture", facture.get());
        req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/details-facture.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
