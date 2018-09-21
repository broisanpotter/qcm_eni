<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <title>Test</title>
</head>
<body>
<div>
    <%@ include file='navbar.jspf' %>
</div>


<h2>Liste des tests </h2>

<div id="page">
    <div id="contenu">

        <div class="table">
            <table>

                <tr>
                    <th>Libelle</th>
                    <th>Duree</th>
                    <th>Description</th>
                </tr>
                <%@ include file="listeTest.jspf" %>
            </table>

    </div>

</div>

</body>
</html>
