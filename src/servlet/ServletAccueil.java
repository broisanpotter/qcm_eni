package servlet;

import entity.ConnectDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAccueil", urlPatterns = "/accueil")
public class ServletAccueil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }
        else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accueil.jsp");
            dispatcher.forward(request, response);
        }

    }
}
