package servlet;

import entity.ConnectDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String mail = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");

        if(mail.equals("") && mail.equals("")) {
            String missInfoMessage = "Il manque des infos !!";
            request.setAttribute("message", missInfoMessage);
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }

        ConnectDB connect = new ConnectDB();
        connect.checkUser(mail, password, connection);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

    }
}
