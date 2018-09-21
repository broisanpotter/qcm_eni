<%@ page import="java.util.List" %>
<%@ page import="entity.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>
<%--

  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 14/09/2018
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion des utilisateurs</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>

<div>
    <%@ include file='../navbar.jspf' %>
</div>
    <div>
        <%@ include file='../header.jspf' %>
    </div>

    <h1>Gestion des utilisateurs</h1>

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

    <a href="/ajoutUtilisateur">Ajouter un utilisateur</a><br>
    <a href="/epreuve/ajouter">Inscrire un utilisateur à un test</a>

    <h2>Liste des candidats</h2>

    <table class="table">
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
        </tr>
    <%
        if(request.getAttribute("listCollaborateur") != null) {

            ArrayList<Utilisateur> listCollaborateur = (ArrayList<Utilisateur>) request.getAttribute("listCollaborateur");

            for(Utilisateur utilisateur : listCollaborateur){
                %>
                <tr>
                    <td><%=utilisateur.getNom()%></td>
                    <td><%=utilisateur.getPrenom()%></td>
                    <td><%=utilisateur.getEmail()%></td>
                    <td><a href="/deleteUtilisateur?id=<%= utilisateur.getIdUtilisateur()%>">Supprimer</a></td>
                    <td><a href="/editUtilisateur?id=<%=utilisateur.getIdUtilisateur()%>">Modifier</a></td>
                </tr>
                <%
            }
        }

        %>
    </table>
        <h2>Liste des collaborateurs</h2>

    <table class="table">
        <tr>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Email</th>
        </tr>
            <%

            if(request.getAttribute("listCandidat") != null) {

                ArrayList<Utilisateur> listCandidat = (ArrayList<Utilisateur>) request.getAttribute("listCandidat");

                for(Utilisateur utilisateur : listCandidat){
                %>
                <tr>
                    <td><%=utilisateur.getNom()%></td>
                    <td><%=utilisateur.getPrenom()%></td>
                    <td><%=utilisateur.getEmail()%></td>
                    <td><a href="/deleteUtilisateur?id=<%= utilisateur.getIdUtilisateur()%>">Supprimer</a></td>
                    <td><a href="/editUtilisateur?id=<%=utilisateur.getIdUtilisateur()%>">Modifier</a></td>
                </tr>
                <%
                }
            }
        %>
    </table>




</body>
</html>
