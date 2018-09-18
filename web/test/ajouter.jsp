<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 14/09/2018
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="entity.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un test</title>
    <style>
        label {width: 150px; display: inline-block}
        input {width: 150px}
        #content div {margin: 3px 0}
        #content{text-align: center; padding: 5px; border: 1px solid; border-radius: 10px}
        body{width: 900px;  margin: auto}
    </style>

    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div>
    <%@ include file='/navbar.jspf' %>
</div>
    <div id="content">
        <h1>Ajouter un test</h1>
        <jsp:useBean id="testCourant" class="entity.Test" scope="session" />
        <form method="post" action="<%=request.getContextPath() %>/test">
            <div>
                <label>Libellé :</label>
                <input type="text" name="tLibelle" >
            </div>
            <div>
                <label>Description :</label>
                <input type="text" name="tDescription" >
            </div>
            <div>
                <label>Durée :</label>
                <input type="text" name="tDuree" >
            </div>
            <div>
                <label>Seuil haut :</label>
                <input type="text" name="tSeuilHaut" >
            </div>
            <div>
                <label>Seuil bas :</label>
                <input type="text" name="tSeuilBas" >
            </div>
            <button type="submit" name="bEnregistrer" value="Enregistrer">Enregistrer</button>
        </form>
    </div>
</body>
</html>
