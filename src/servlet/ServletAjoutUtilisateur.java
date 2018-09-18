package servlet;

import Dal.DalUser;
import entity.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAjoutUtilisateur", urlPatterns = "/ajoutUtilisateur")
public class ServletAjoutUtilisateur extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside the post");

        if (request.getParameter("prenom").isEmpty() || request.getParameter("nom").isEmpty() || request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("statut").isEmpty() || request.getParameter("promo").isEmpty() ) {
            String missInfoMessage = "Il manque des infos mais je te dirais pas ou !!";
            request.setAttribute("message", missInfoMessage);
            request.getRequestDispatcher("utilisateur/ajoutUtilisateur.jsp").forward(request, response);
        }
        else {
            int statut = Integer.parseInt(request.getParameter("statut"));
            try {
                DalUser.ajouterUser(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("password"), statut,request.getParameter("promo"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }

        else {
            request.getRequestDispatcher("utilisateur/ajoutUtilisateur.jsp").forward(request, response);
        }
    }
}
