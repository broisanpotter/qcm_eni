<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Liste d'epreuve</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style>
    </style>
</head>
<body>
<div>
    <%@ include file='/navbar.jspf' %>
</div>
    <h2>Liste d'epreuve</h2>
<div>
    <c:forEach var="epreuve" items="${epreuvesListe}">
        <a href="/epreuve?idEpreuve=${epreuve.idEpreuve}">${epreuve.test.libelle}(${epreuve.test.description})</a><br>
    </c:forEach>
</div>

</body>
</html>
