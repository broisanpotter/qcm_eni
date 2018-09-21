<%@ page import="java.util.List" %>
<%@ page import="entity.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/09/2018
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout Utilsateur</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
    <div>
        <%@ include file='../navbar.jspf' %>
    </div>
    <div>
        <%@ include file='../header.jspf' %>
    </div>

    <h1>Création d'un Compte</h1>

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

    <form action="/ajoutUtilisateur" method="post">
        <input type="text" name="prenom" placeholder="Prénom"><br>
        <input type="text" name="nom" placeholder="Nom"><br>
        <input type="email" name="email" placeholder="email"><br>
        <input type="text" name="password" placeholder="mot de passe"><br>

        <SELECT name="statut" size="1">
            <%
                if(request.getAttribute("listProfil") != null) {

                    ArrayList<Profil> listProfil = (ArrayList<Profil>) request.getAttribute("listProfil");

                    for(Profil pro : listProfil){
                        %>
                        <OPTION value="<%= pro.getCodeProfil() %>"><%= pro.getLibelle() %></OPTION>
                        <%
                    }
                }
            %>
        </SELECT><br>

        <SELECT name="promo" size="1">
        <%
        if(request.getAttribute("listPromotion") != null) {

                ArrayList<Promotion> listPromotion = (ArrayList<Promotion>) request.getAttribute("listPromotion");

                for(Promotion promotion : listPromotion){
                    %>
                    <OPTION value="<%= promotion.getCodePromo() %>"><%= promotion.getLibelle() %></OPTION>
                    <%
                }
            }
        %>
        </SELECT><br>
        <input type="submit">

    </form>

</body>
</html>
