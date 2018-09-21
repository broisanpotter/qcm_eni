package servlet.epreuve;

import Dal.*;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "ServletCreation", urlPatterns = "/epreuve/ajouter")
public class ServletCreation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }
        else {
            Date dateDebutValidite = null;
            Date dateFinValidite = null;
            Boolean formulaireNonCorrect = false;
            Date date = new Date();
            String message = "";

            SimpleDateFormat formatDate = new SimpleDateFormat("yy-MM-dd");
            String[] utilisateursListe = request.getParameterValues("utilisateursListe");
            Integer idTest = Integer.parseInt(request.getParameter("test"));
            try {

                dateDebutValidite = formatDate.parse(request.getParameter("dateDebutValidite"));
                dateFinValidite = formatDate.parse(request.getParameter("dateFinValidite"));
            } catch (ParseException e) {

                e.printStackTrace();
            }
            if (utilisateursListe == null) {

                formulaireNonCorrect = true;
                message = message + "Pas d'utilsateur de selectionnée.";
            }
            if (dateFinValidite == null || dateDebutValidite == null) {

                formulaireNonCorrect = true;
                if (message.length() > 0) {
                    message = message + "<br>";
                }
                message = message + "Il manque une date.";
            }
            else{
                if (dateDebutValidite.compareTo(dateFinValidite) == 1) {

                    formulaireNonCorrect = true;
                    if (message.length() > 0) {
                        message = message + "<br>";
                    }
                    message = message + "La date de fin doit être supérieur a la date de bébut.";
                }
                if(dateDebutValidite.compareTo(date) < 1){

                    formulaireNonCorrect = true;
                    if (message.length() > 0) {
                        message = message + "<br>";
                    }
                    message = message + "La date de debut doit être supèrieur ou egal à la date du jour..";
                }
            }

            if (formulaireNonCorrect) {

                request.setAttribute("codeMessage", "error");
                request.setAttribute("message", message);
                request.setAttribute("dateDebutValidite", request.getParameter("dateDebutValidite"));
                request.setAttribute("dateFinValidite", request.getParameter("dateFinValidite"));
            } else {

                for (String idUtilisateur : utilisateursListe) {

                    Epreuve epreuve = new Epreuve();
                    epreuve.setDateDebutValidite(new java.sql.Date(dateDebutValidite.getTime()));
                    epreuve.setDateFinValidite(new java.sql.Date(dateFinValidite.getTime()));
                    epreuve.setEtat("EA");
                    epreuve.setIdTest(idTest);
                    epreuve.setIdUtilisateur(Integer.parseInt(idUtilisateur));

                    try {

                        Test test = DalTest.getTest(idTest);
                        ArrayList<Question> questionsListe = DalQuestion.getQuestionByTheme(test);
                        SectionTest sectionTest = DalSectionTest.getSectionTest(test);
                        ArrayList<Question> questionListSelectionnee = new ArrayList<Question>();

                        if (questionsListe.size() >= sectionTest.getNbQuestionsATirer()) {
                            do {
                                Integer random = (int) (Math.random() * (questionsListe.size()));
                                if (!questionListSelectionnee.contains(questionsListe.get(random))) {
                                    questionListSelectionnee.add(questionsListe.get(random));
                                }
                            } while (questionListSelectionnee.size() < sectionTest.getNbQuestionsATirer());


                            Integer idEpreuve = DalEpreuve.setEpreuve(epreuve);
                            Integer i = 1;
                            for (Question question : questionListSelectionnee) {

                                QuestionTirage questionTirage = new QuestionTirage();
                                questionTirage.setNumOrdre(i);
                                questionTirage.setEstMarquee(false);
                                questionTirage.setIdQuestion(question.getIdQuestion());
                                questionTirage.setIdEpreuve(idEpreuve);
                                DalQuestionTirage.setQuestionTirage(questionTirage);
                                i++;
                            }
                        } else {
                            request.setAttribute("codeMessage", "error");
                            request.setAttribute("message", "Il n'y a pas assez de question dans ce thème pour Crée cette épreuve.");
                        }
                        request.setAttribute("codeMessage", "valid");
                        request.setAttribute("message", "Les modification ont été ajouter.");
                    } catch (SQLException e) {

                        request.setAttribute("codeMessage", "error");
                        request.setAttribute("message", "Erreur SQL.");
                        e.printStackTrace();
                    }
                }
            }

            Formulaire(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }
        else {
            Formulaire(request, response);
        }
    }

    private void Formulaire(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Test> testsListe = new ArrayList<Test>();
        ArrayList<Utilisateur> UtilisateursListe = new ArrayList<Utilisateur>();

        try {
            testsListe = (ArrayList<Test>)DalTest.lister();
            UtilisateursListe = (ArrayList<Utilisateur>)DalUser.listerUser(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("testsListe", testsListe);
        request.setAttribute("utilisateursListe", UtilisateursListe);
        request.getServletContext().getRequestDispatcher("/epreuve/ajout.jsp").forward(request, response);
    }
}
