package servlet;

import Dal.DalProfil;
import Dal.DalPromotion;
import Dal.DalUser;
import entity.ConnectDB;
import entity.Profil;
import entity.Promotion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletAjoutUtilisateur", urlPatterns = "/ajoutUtilisateur")
public class ServletAjoutUtilisateur extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("prenom").isEmpty() || request.getParameter("nom").isEmpty() || request.getParameter("email").isEmpty() || request.getParameter("password").isEmpty() || request.getParameter("statut").isEmpty() || request.getParameter("promo").isEmpty() ) {
            String missInfoMessage = "Il manque des infos mais je te dirais pas ou !!";
            request.setAttribute("message", missInfoMessage);
            request.getRequestDispatcher("utilisateur/ajoutUtilisateur.jsp").forward(request, response);
        }
        else {
            int statut = Integer.parseInt(request.getParameter("statut"));
            try {
                DalUser.ajouterUser(request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("email"), request.getParameter("password"), statut,request.getParameter("promo"));
                response.sendRedirect("/accueilUtilisateur");
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
            try {
                ArrayList<Promotion> listPromotion = DalPromotion.getAllPromotion();
                ArrayList<Profil> listProfil = DalProfil.getAllProfil();

                if(listPromotion != null && listProfil != null) {
                    request.setAttribute("listPromotion", listPromotion);
                    request.setAttribute("listProfil", listProfil);
                    request.getRequestDispatcher("utilisateur/ajoutUtilisateur.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
