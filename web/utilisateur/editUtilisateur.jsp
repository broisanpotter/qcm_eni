<%@ page import="entity.Profil" %>
<%@ page import="entity.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Promotion" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/09/2018
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
    <div>
        <%@ include file='../navbar.jspf' %>
    </div>
    <div>
        <%@ include file='../header.jspf' %>
    </div>
    <h1>On modifie un super utilisateur youpi</h1>

    <div>
        <%
            String message = (String)request.getAttribute("message");
            if(message != null) {
        %><span>
            <%= message %>
            </span><%
        }
    %>
    </div>


    <%
        if(request.getAttribute("user") != null) {
            Utilisateur user = (Utilisateur) request.getAttribute("user");
        %>
            <form action="/editUtilisateur" method="post">
                <input type="text" name="prenom" value="<%= user.getPrenom() %>"><br>
                <input type="text" name="nom" value="<%= user.getNom() %>"><br>
                <input type="email" name="email" value="<%= user.getEmail() %>"><br>
                <input type="hidden" name="id" value="<%= user.getIdUtilisateur() %>">

                <SELECT name="statut" size="1">
                    <%
                    if(request.getAttribute("listProfil") != null) {

                        ArrayList<Profil> listProfil = (ArrayList<Profil>) request.getAttribute("listProfil");

                        for(Profil pro : listProfil){
                            if(user.getProfil().equals(pro.getCodeProfil())) {
                                %>
                                <OPTION value="<%= pro.getCodeProfil() %>" selected="selected"><%= pro.getLibelle() %> </OPTION>
                                <%
                            }
                            else {
                                %>
                                <OPTION value="<%= pro.getCodeProfil() %>"><%= pro.getLibelle() %></OPTION>
                                <%
                            }
                        }
                    }
                    %>
                </SELECT><br>

                <SELECT name="promo" size="1">
                    <%
                    if(request.getAttribute("listPromotion") != null) {

                        ArrayList<Promotion> listPromotion = (ArrayList<Promotion>) request.getAttribute("listPromotion");

                        for(Promotion promotion : listPromotion){
                            if(user.getPromotion().equals(promotion.getCodePromo())) {
                                %>
                                <OPTION value="<%= promotion.getCodePromo() %>" selected="selected"><%= promotion.getLibelle() %></OPTION>
                                <%
                            }
                            else {
                                %>
                                <OPTION value="<%= promotion.getCodePromo() %>"><%= promotion.getLibelle() %></OPTION>
                                <%
                            }

                        }
                    }
                    %>
                </SELECT><br>
                <input type="submit">

            </form>
        <%
















        }
    %>
</body>
</html>
