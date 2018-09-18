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
    <link rel="stylesheet" href="css/bootstrap.css">
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
        <input type="text" name="statut" placeholder="statut"><br>
        <input type="text" name="promo" placeholder="code Promo"><br>
        <input type="submit">

    </form>

</body>
</html>
