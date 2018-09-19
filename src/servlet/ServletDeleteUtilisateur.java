package servlet;

import Dal.DalUser;
import entity.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteUtilisateur", urlPatterns = "/deleteUtilisateur")
public class ServletDeleteUtilisateur extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean checkSession = ConnectDB.checkSession(request, response);

        if(!checkSession) {
            response.sendRedirect("/login");
        }
        else {
            if(request.getParameter("id") != null) {
                System.out.println(request.getParameter("id"));
                int id = Integer.parseInt(request.getParameter("id"));

                try {
                    DalUser.supprimerUser(id);
                    response.sendRedirect("/accueilUtilisateur");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
