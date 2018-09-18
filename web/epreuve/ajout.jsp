<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/09/2018
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Ajout d'une epreuve à un candidat</title>
    <style>
        .error{
            background-color: rgba(255,0,0,0.2);
            border: solid 1px rgba(255,0,0,0.4);
            padding: 5px;

        }
        .valid{
            background-color: rgba(0,255,0,0.2);
            border: solid 1px rgba(0,255,0,0.4);
            padding: 5px;
            border-radius: 10px;
        }
        input, select, label {
            width: 250px;
            box-sizing: border-box;
            display: inline-block;
            vertical-align: middle;
            margin: 3px;
        }
        form, button{
            margin-top: 25px;
        }
    </style>
</head>
<body>
    <div style="margin: auto; width: 900px;text-align: center">
        <div class="${codeMessage}">
                ${message}
        </div>
        <form method="post" action="/epreuve/ajouter">
            <div>
                <label>Selectionnez des utilisateurs :</label>
                <select name="utilisateursListe" multiple>
                    <c:forEach items="${utilisateursListe}" var="utilisateur">
                        <option value="${utilisateur.idUtilisateur}">${utilisateur.nom} ${utilisateur.prenom}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>Selectionnez des tests :</label>
                <select name="test">
                    <c:forEach items="${testsListe}" var="test">
                        <option value="${test.idTest}">${test.libelle}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label>Date de début de validité :</label>
                <input name="dateDebutValidite" type="date" value="${dateDebutValidite}">
            </div>
            <div>
                <label>Date de fin de validité :</label>
                <input name="dateFinValidite" type="date" value="${dateFinValidite}"><br>
            </div>
            <button>Valider</button>
        </form>
    </div>
</body>
</html>
