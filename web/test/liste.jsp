<%@ page import="entity.Test" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des tests</title>
</head>
<style>
    #listeTest {display: flex; flex-direction: column}
    .ligne {border-radius: 15px; padding: 5px; margin: 3px 0; background-color: lightgray; box-shadow: 3px 3px 5px #000000;}
    h1 {text-align: center}
</style>
<body>

<div id="page">

<div id="listeTest">
    <h1>Liste des tests</h1>
    <!--<div class="ligne">
        <div style="display: inline-block">Libelle</div><div style="display: inline-block">Durée</div><div style="display: inline-block">Description</div>
    </div>-->
    <%
        ArrayList<Test> listeTest = (ArrayList<Test>)request.getSession().getAttribute("listeTest");
        for(Test t : listeTest) {
    %>
    <div class="ligne">
        <div><a href="http://localhost:8080/test/<%=t.getIdTest()%>"><%=t.getLibelle() %></a>( <%=t.getDuree() %> min ) </div>
        <div style="font-style: italic; padding: 0 25px"><%= t.getDescription() %></div>
    </div>
    <% } %>
</div>
</div>