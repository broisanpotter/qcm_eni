<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/09/2018
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>test</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div>
    <%@ include file='navbar.jspf' %>
</div>

    <div>
        <%@ include file='header.jspf' %>
    </div>

    <h1>Connexion</h1>

    <div>
        <%
            String message = (String)request.getAttribute("message");
        if(message != null) {
            %><span>
            <%= message %>
            </span><%
        }
        %>
    </div>

    <form method="post">
        <input type="email" name="email">
        <input type="password" name="password">
        <input type="submit">
    </form>

</body>
</html>
