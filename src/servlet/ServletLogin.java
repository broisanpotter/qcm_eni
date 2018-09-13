package servlet;

import entity.ConnectDB;
import entity.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {

     private Connection connectToDb() {
         ConnectDB connect = new ConnectDB();
         return connect.connect();
     }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection connection = this.connectToDb();

        if (request.getParameter("email") == null || request.getParameter("password") == null) {

            String missInfoMessage = "Il manque des infos !!";
            request.setAttribute("message", missInfoMessage);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            String mail = request.getParameter("email");
            String password = request.getParameter("password");

            ConnectDB connect = new ConnectDB();
            Utilisateur insideTheMatrix = connect.checkUser(mail, password, connection);

            if(insideTheMatrix != null) {
                HttpSession session = request.getSession();

                if (session.getAttribute("mail") == null && session.getAttribute("password") == null){

                    session.setAttribute("id", insideTheMatrix.getIdUtilisateur());
                    session.setAttribute("mail", insideTheMatrix.getEmail());
                    session.setAttribute("password", insideTheMatrix.getPassword());

                    request.setAttribute("session", session);
                    request.getRequestDispatcher("/header.jsp").forward(request, response);
                }


                response.sendRedirect("/accueil.jsp");
            }
            else {
                String missInfoMessage = "T'existe pas tocard !!!!";
                request.setAttribute("message", missInfoMessage);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

    }
}
