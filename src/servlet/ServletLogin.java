package servlet;

import entity.ConnectDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {

     private void connectToDb() {
         ConnectDB connect = new ConnectDB();
         connect.connectToDb();
     }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        connectToDb();
        System.out.println("connect to db");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        connectToDb();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);

    }
}
