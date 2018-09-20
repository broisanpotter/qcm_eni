<%@ page import="entity.*" %><%--
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
    <title>Epreuve</title>
</head>
<body>
    <div>
        <c:forEach var="questionTirage" items="${questionsTiragesListe}">
            ${ questionTirage.question.enonce }<br>
            <c:forEach var="proposition" items="${questionTirage.question.propositionsListe}">
                <input type="checkbox" value="${proposition.idProposition}">${ proposition.enonce }<br>
            </c:forEach><br>
            <hr>
        </c:forEach>
    </div>
<script>


</script>

</body>
</html>
