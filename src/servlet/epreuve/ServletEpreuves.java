package servlet.epreuve;

import Dal.DalEpreuve;
import entity.Epreuve;
import entity.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletEpreuves", urlPatterns = "/epreuves")
public class ServletEpreuves extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<Epreuve> EpreuvesListe = new ArrayList<Epreuve>();

        try {
            EpreuvesListe = DalEpreuve.getEpreuves(((Utilisateur)session.getAttribute("user")).getIdUtilisateur());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("epreuvesListe", EpreuvesListe);
        request.getServletContext().getRequestDispatcher("/epreuve/liste.jsp").forward(request, response);
    }
}
