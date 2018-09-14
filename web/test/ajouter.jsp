<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 14/09/2018
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un test</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/test/ajouter">
        <div>
            <label>Libellé :</label>
            <input type="text" name="libelle">
        </div>
        <div>
            <label>Description :</label>
            <input type="text" name="description">
        </div>
        <div>
            <label>Durée :</label>
            <input type="text" name="duree">
        </div>
        <div>
            <label>Seuil haut :</label>
            <input type="text" name="seuilHaut">
        </div>
        <div>
            <label>Seuil bas :</label>
            <input type="text" name="seuilBas">
        </div>
        <button>Valider</button>
    </form>
</body>
</html>
