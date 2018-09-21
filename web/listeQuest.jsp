<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 14/09/2018
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <title>Questions</title>
</head>
<body>
<div>
    <%@ include file='navbar.jspf' %>
</div>
<h2>Liste des questions </h2>
<div id="page">
    <div id="contenu">
        <table class="table">
            <tr>
                <th>Enonce</th>
                <th>Media</th>
                <th>Points</th>
                <th>idTheme</th>
            </tr>
        <%@ include file="listeQuest.jspf" %>
        </table>
    </div>


</div>
</body>
</html>
