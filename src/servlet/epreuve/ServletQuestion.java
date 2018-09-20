package servlet.epreuve;

import Dal.DalEpreuve;
import Dal.DalQuestionTirage;
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

@WebServlet(name = "ServletQuestion", urlPatterns = "/epreuve")
public class ServletQuestion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer idEpreuve = Integer.parseInt(request.getParameter("idEpreuve"));
        ArrayList<QuestionTirage> questionsTiragesListe = new ArrayList<QuestionTirage>();
        try {
            Epreuve epreuve = DalEpreuve.getEpreuve(idEpreuve);
            questionsTiragesListe = DalQuestionTirage.getQuestionsTirageListe(idEpreuve);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("questionsTiragesListe", questionsTiragesListe);
        request.getServletContext().getRequestDispatcher("/epreuve/questions.jsp").forward(request, response);

    }
}
