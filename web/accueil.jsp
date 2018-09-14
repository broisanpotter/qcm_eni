<%@ page import="entity.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/09/2018
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>YO</title>
</head>
<body>
    <div>
        <jsp:include page='header.jsp' />
    </div>
    <h1>Accueil</h1>
    <%
    int profil = 0;

    if(session.getAttribute("user") != null) {
        Utilisateur utilisateur = (Utilisateur)session.getAttribute("user");
        profil = utilisateur.getProfil();

    }
    %>
    <ul>

    <% if(profil == 2) {
        %>
        <li>Ajouter un candidat</li>
        <li>Consulter les resultats</li>
        <li>Voir les tests</li>
        <%
    }
    else {
        %>
        <li>Passer un test</li>
        <li>Reprendre un test</li>
        <li>Consulter ses résultats</li>
        <%
    }
    %>
    </ul>

</body>
</html>
