<%@ page import="java.util.List" %>
<%@ page import="entity.Utilisateur" %>
<%@ page import="java.util.ArrayList" %><%--
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
</head>
<body>
    <div>
        <jsp:include page='../header.jsp' />
    </div>

    <h1>Gestion des utilisateurs</h1>

    <h2>Liste des collaborateurs</h2>

    <%
        if(request.getAttribute("listCollaborateur") != null) {

            ArrayList<Utilisateur> listCollaborateur = (ArrayList<Utilisateur>) request.getAttribute("listCollaborateur");

            for(Utilisateur utilisateur : listCollaborateur){
                %>
                <tr>
                    <td><%=utilisateur.getNom()%></td>
                    <td><%=utilisateur.getPrenom()%></td>
                    <td><%=utilisateur.getEmail()%></td>
                </tr><br>
                <%
            }
        }

        %>

        <h2>Liste des candidats</h2>

        <%

        if(request.getAttribute("listCandidat") != null) {

            ArrayList<Utilisateur> listCandidat = (ArrayList<Utilisateur>) request.getAttribute("listCandidat");

            for(Utilisateur utilisateur : listCandidat){
            %>
            <tr>
                <td><%=utilisateur.getNom()%></td>
                <td><%=utilisateur.getPrenom()%></td>
                <td><%=utilisateur.getEmail()%></td>
            </tr>
            <%
            }
        }
    %>




</body>
</html>
