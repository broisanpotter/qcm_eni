package servlet;

import Dal.DalUser;
import entity.ConnectDB;
import entity.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletAccueilUtilisateur", urlPatterns = "/accueilUtilisateur")
public class ServletAccueilUtilisateur extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }

        else {
            try {

                ArrayList<Utilisateur> listCandidat = (ArrayList<Utilisateur>) DalUser.listerUser(1);
                ArrayList<Utilisateur> listCollaborateur = (ArrayList<Utilisateur>) DalUser.listerUser(2);
                request.setAttribute("listCollaborateur", listCollaborateur);
                request.setAttribute("listCandidat", listCandidat);
                request.getRequestDispatcher("utilisateur/accueilUtilisateur.jsp").forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
