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


@WebServlet(urlPatterns = "/app/factures")
public class FactureListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FactureDao factureDao = new FactureDao();
        System.out.println("ALL FACTURES");
        List<Facture> factureList = factureDao.getAll();
        req.setAttribute("factureList", factureList);
        System.out.println(factureList);
        req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/list-facture.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
