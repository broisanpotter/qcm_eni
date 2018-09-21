<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 18/09/2018
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="entity.Utilisateur" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier un test</title>
    <style>
        label {width: 150px; display: inline-block}
        input {width: 150px}
        #content div {margin: 3px 0}
        #content{text-align: center; padding: 5px; border: 1px solid; border-radius: 10px}
        body{width: 900px;  margin: auto}
    </style>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
</head>
<body>
<div>
    <%@ include file='/navbar.jspf' %>
</div>
<div id="content">
    <h1>Modifier un test</h1>
    <jsp:useBean id="testCourant" class="entity.Test" scope="session" />
    <form method="post" action="<%=request.getContextPath() %>/test">
        <div>
            <label>Id :</label>
            <input type="text" name="tIdentifiant" readonly="readonly" size="10" value="<jsp:getProperty property="idTest" name="testCourant"/>" >
        </div>
        <div>
            <label>Libellé :</label>
            <input type="text" name="tLibelle" value="<jsp:getProperty property="libelle" name="testCourant"/>" >
        </div>
        <div>
            <label>Description :</label>
            <input type="text" name="tDescription" value="<jsp:getProperty property="description" name="testCourant"/>"  >
        </div>
        <div>
            <label>Durée :</label>
            <input type="text" name="tDuree" value="<jsp:getProperty property="duree" name="testCourant"/>"  >
        </div>
        <div>
            <label>Seuil haut :</label>
            <input type="text" name="tSeuilHaut" value="<jsp:getProperty property="seuilHaut" name="testCourant"/>"  >
        </div>
        <div>
            <label>Seuil bas :</label>
            <input type="text" name="tSeuilBas" value="<jsp:getProperty property="seuilBas" name="testCourant"/>"  >
        </div>
        <button type="submit" name="bEnregistrer" value="Enregistrer">Enregistrer</button>
    </form>
</div>
</body>
</html>
