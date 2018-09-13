<%@ page import="entity.Utilisateur" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <% Utilisateur utilisateur = new Utilisateur(session.getAttribute("user")); %>

    <h1>Bienvenue sur ce super site de qcm on va super bien rigoler <%= utilisateur.getPrenom() + " " +utilisateur.getNom()%></h1>

    <% if(session.getAttribute("user") != null) {
        %>
        <form method="post" action="${pageContext.request.contextPath}/deconnexion">
            <input class="btn" type="submit" value="Deconnection">
        </form>
        <%
    }%>



</body>
</html>
