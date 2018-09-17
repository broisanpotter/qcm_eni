package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletDeconnexion", urlPatterns = "/deconnexion")
public class ServletDeconnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getParameter("user");
        if(session.getAttribute("user") == null){
            response.sendRedirect("/login");
        } else {
            session.getAttribute("user");
            session.invalidate();
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
