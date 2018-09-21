<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 20/09/2018
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Resultats</title>
</head>
<body>
<div>
    <%@ include file='navbar.jspf' %>
</div>


<h2>Liste des resultats </h2>

<div id="page">
    <div id="contenu">

        <div class="table">
            <table>

                <tr>
                    <th>Test</th>
                    <th>Resultat obtenu</th>
                </tr>
                <%@ include file="listeResultat.jspf" %>
            </table>

        </div>

    </div>

</body>
</html>
