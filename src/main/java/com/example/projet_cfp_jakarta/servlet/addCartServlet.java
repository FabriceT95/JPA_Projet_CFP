package com.example.projet_cfp_jakarta.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/app/cart/add")
public class addCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String id = req.getParameter("id");

        ServletContext application = getServletConfig().getServletContext();

        if(application.getAttribute("cart") == null) {
            HashMap<String,Integer> cart = new HashMap<>();
            cart.put(id, quantity);
            application.setAttribute("cart", cart);
        } else {

            HashMap<String,Integer> cart = (HashMap<String, Integer>) application.getAttribute("cart");
            cart.merge(id, quantity, Integer::sum);
            application.setAttribute("cart", cart);
        }

        resp.sendRedirect(req.getContextPath() + "/app/factures/add");
    }
}
