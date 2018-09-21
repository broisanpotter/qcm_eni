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
    <link rel="stylesheet" href="css/bootstrap.css">
    <title>Epreuve</title>
    <style>
        #accueil{
            display: block;
        }
        #questions{
            display: none;
        }
    </style>
</head>
<body>
    <div>
        <%@ include file='/navbar.jspf' %>
    </div>
    <div id="accueil">
        <button id="commencer">Commencer</button>
    </div>
    <div id="questions">
        <c:forEach var="questionTirage" items="${questionsTiragesListe}">
            <div class="questions" idEpreuve="${epreuve.idEpreuve}" idQuestion="${questionTirage.question.idQuestion}">
                ${ questionTirage.question.enonce }<br>
                <c:forEach var="proposition" items="${questionTirage.question.propositionsListe}">
                    <input class="proposition" type="checkbox" value="${proposition.idProposition}">${ proposition.enonce }<br>
                </c:forEach>
            </div>
            <hr>
        </c:forEach>
    </div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        $("#commencer").on('click', function(){
            $("#accueil").css("display","none");
            $("#questions").css("display","block");
        });

        $(".proposition").on("click", function(){
            var idQuestion = $(this).parent().attr("idQuestion");
            var idEpreuve = $(this).parent().attr("idEpreuve");
            var idProposition = $(this).val();
            //$.post("/epreuve", {"idEpreuve": idEpreuve, "idQuestion": idQuestion, "idProposition": idProposition});

            var req = "/epreuve";
            var parametres = "idEpreuve=" + idEpreuve + "&idQuestion=" + idQuestion + "&idProposition=" + idProposition;
console.log(parametres);
            post = new XMLHttpRequest();
            post.open("POST", req, true);
            post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            post.send(parametres);
        });
    });

</script>

</body>
</html>
