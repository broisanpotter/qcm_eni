package servlet.epreuve;

import Dal.DalEpreuve;
import Dal.DalQuestionTirage;
import Dal.DalReponseTirage;
import entity.ConnectDB;
import entity.Epreuve;
import entity.QuestionTirage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletEpreuve", urlPatterns = "/epreuve")
public class ServletEpreuve extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean checkSession = ConnectDB.checkSession(request, response);
            Integer idEpreuve = Integer.parseInt(request.getParameter("idEpreuve"));
            Integer idQuestion = Integer.parseInt(request.getParameter("idQuestion"));
            Integer idReponse = Integer.parseInt(request.getParameter("idProposition"));
            try {
                DalReponseTirage.setReponseTirage(idEpreuve, idReponse, idQuestion);
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean checkSession = ConnectDB.checkSession(request, response);

        if (!checkSession) {
            response.sendRedirect("/login");
        } else {
            if (request.getParameter("idEpreuve") == null) {

                response.sendRedirect("/epreuves");
            } else {
                Integer idEpreuve = Integer.parseInt(request.getParameter("idEpreuve"));
                ArrayList<QuestionTirage> questionsTiragesListe = new ArrayList<QuestionTirage>();
                Epreuve epreuve = null;
                try {
                    epreuve = DalEpreuve.getEpreuve(idEpreuve);
                    questionsTiragesListe = DalQuestionTirage.getQuestionsTirageListe(idEpreuve);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("epreuve", epreuve);
                request.setAttribute("questionsTiragesListe", questionsTiragesListe);
                request.getServletContext().getRequestDispatcher("/epreuve/questions.jsp").forward(request, response);

            }
        }
    }
}
