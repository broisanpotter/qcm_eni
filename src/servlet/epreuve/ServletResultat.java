package servlet.epreuve;

import Dal.DalEpreuve;
import Dal.DalQuestion;
import entity.Epreuve;
import entity.Question;
import entity.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletResultat", urlPatterns="/resultat")
public class ServletResultat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        List<Epreuve> listeResult = null;

        HttpSession s = request.getSession();
        Utilisateur u = (Utilisateur)s.getAttribute("user");
        // Construire la liste des formations et la placer en session
        try {
            listeResult = DalEpreuve.getEpreuves(u.getIdUtilisateur());
        }catch (SQLException sqle){
            // Placer l'objet représentant l'exception dans le contexte de requete
            request.setAttribute("erreur", sqle);
            // Passer la main à la page de présentation des erreurs
            dispatcher = request.getRequestDispatcher("/erreur.jsp");
            dispatcher.forward(request, response);
            return;
        }
        request.getSession().setAttribute("listeResultat", listeResult);
        dispatcher = request.getRequestDispatcher("/listeResultat.jsp");
        dispatcher.forward(request, response);

    }
}
