package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Dal.DalTest;
import entity.*;

@WebServlet(name = "ServletTest", urlPatterns = "/test")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

  /*  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        List<Test> listeTest = null;

        // Construire la liste des formations et la placer en session
        try {
            listeTest = DalTest.lister();
        }catch (SQLException sqle){
            // Placer l'objet représentant l'exception dans le contexte de requete
            request.setAttribute("erreur", sqle);
            // Passer la main à la page de présentation des erreurs
            dispatcher = request.getRequestDispatcher("/erreur.jsp");
            dispatcher.forward(request, response);
            return;
        }
        request.getSession().setAttribute("listeTest", listeTest);
        dispatcher = request.getRequestDispatcher("/listeTest.jsp");
        dispatcher.forward(request, response);

    }*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        String ajouterParam = request.getParameter("bAjouter"); // Ajout d'un nouveau test
        String enregistrerParam = request.getParameter("bEnregistrer"); // Enregistrement du test courant

        // Récupérer la liste des tests
        ArrayList<Test> listeTest = (ArrayList<Test>) request.getSession().getAttribute("listeTest");
        if (listeTest== null) listeTest=new ArrayList<Test>();// Pour le 1er passage dans la servlet


        // Identification de l'action Modifier (et de la formation à modifier)
        String actionModifier = null;
        Test testAModifer=null;
        for(int i=0;i<listeTest.size();i++) {
            actionModifier=request.getParameter("bModifier_"+i);
            if (actionModifier!=null) {
                testAModifer = listeTest.get(i);
                break;
            }
        }

        // L'action est "Modifier" : on positione la formation à modifier comme formationCourante
        if (testAModifer!=null) {
            request.getSession().setAttribute("testCourant", testAModifer);
            dispatcher = request.getRequestDispatcher("/test/modifierTest.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Si l'action est "Ajouter", création d'une nouvelle formation prérenseignée qui devient la formation courante
        // La valeur -1 comme identifiant n'est possible que pour une formation qui n'est pas encore en base
        else if (ajouterParam!=null) {
            Test nouveauTest = new Test(-1);
            request.getSession().setAttribute("testCourant",nouveauTest);
            dispatcher = request.getRequestDispatcher("/test/ajouter.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // L'action est l'enregistrement d'une formation (nouvelle ou déjà en base)
        else if("Enregistrer".equals(enregistrerParam)) {

            Test testCourant = (Test)request.getSession().getAttribute("testCourant");

            if (testCourant==null) {
                dispatcher = request.getRequestDispatcher("/listeTest.jsp");
                dispatcher.forward(request, response);
                return;
            }

            try {

                // Récupération et formatage des valeurs saisies

                // Mise à jour de testCourant
                testCourant.setLibelle(request.getParameter("tLibelle"));
                testCourant.setDescription(request.getParameter("tDescription"));
                testCourant.setDuree(Integer.parseInt(request.getParameter("tDuree")));
                testCourant.setSeuilHaut(Integer.parseInt(request.getParameter("tSeuilHaut")));
                testCourant.setSeuilBas(Integer.parseInt(request.getParameter("tSeuilBas")));

                // Enregistrement d'un nouveau test
                if (testCourant.getIdTest()==-1 )
                {
                    DalTest.ajouterTest(testCourant);
                }
                // Modification d'un test existant
                else {
                    DalTest.modifier(testCourant);
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                redirectionErreur(sqle, request, response);
                return;
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                redirectionErreur(nfe, request, response);
                return;
            }
        }

        // Suppression d'une formation
        else {
            // Identification de la formation à supprimer
            String actionSupprimer = null;
            Test testASupprimer=null;
            for(int i=0;i<listeTest.size();i++) {
                actionSupprimer=request.getParameter("bSupprimer_"+i);
                if (actionSupprimer!=null) {
                    testASupprimer = listeTest.get(i);
                    break;
                }
            }

            if (testASupprimer!=null) {
                try {
                    DalTest.supprimerTest(testASupprimer);
                } catch (SQLException sqle) {
                    redirectionErreur(sqle, request, response);
                    return;
                }

                request.getSession().removeAttribute("formationCourante");
            }
        }

        // Construire la liste des formations et la placer en session
        try {
            listeTest = DalTest.lister();
        }catch (SQLException sqle){
            redirectionErreur(sqle, request, response);
            return;
        }
        request.getSession().setAttribute("listeTest", listeTest);
        dispatcher = request.getRequestDispatcher("/listeTest.jsp");
        dispatcher.forward(request, response);
    }

    protected void redirectionErreur(Exception e, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Placer l'objet représentant l'exception dans le contexte de requete
        request.setAttribute("erreur", e);
        // Passer la main à la page de présentation des erreurs
        RequestDispatcher dispatcher = request.getRequestDispatcher("/erreur.jsp");
        dispatcher.forward(request, response);

    }
}
