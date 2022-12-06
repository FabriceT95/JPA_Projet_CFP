package com.example.projet_cfp_jakarta.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = LoginServlet.URL)
public class LoginServlet extends HttpServlet {


    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET LOGIN PAGE");

        req.getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("qwerty")) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("username", username);
            // Expiration after 30 minutes
            session.setMaxInactiveInterval(30 * 60);

            Cookie cookieU = new Cookie("username", username);
            resp.addCookie(cookieU);

            resp.sendRedirect("/app/clients");
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

    }
}