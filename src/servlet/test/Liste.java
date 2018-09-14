package servlet.test;

import Dal.DalTest;
import entity.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TestListe", urlPatterns = "/test/liste")
public class Liste extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        List<Test> listeTest = null;

        // Construire la liste des formations et la placer en session
        try {
            listeTest = DalTest.lister();
        }catch (SQLException sqle){
            // Placer l'objet représentant l'exception dans le contexte de requete
            request.setAttribute("erreur", sqle);
            // Passer la main à la page de présentation des erreurs
            dispatcher = request.getRequestDispatcher("/erreur/erreur.jsp");
            dispatcher.forward(request, response);
            return;
        }
        request.getSession().setAttribute("listeTest", listeTest);
        dispatcher = request.getRequestDispatcher("/test/liste.jsp");
        dispatcher.forward(request, response);

    }
}
