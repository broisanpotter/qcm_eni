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
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div>
    <%@ include file='navbar.jspf' %>
</div>

<div>
    <%@ include file='header.jspf' %>
</div>




<body id="LoginForm">
<div class="container">
    <h1 class="form-heading">Connexion</h1>
    <div class="login-form">
        <div class="main-div">
            <div class="panel">
                <p>Entrez votre email et votre mot de passe</p>
            </div>
            <%
                String message = (String)request.getAttribute("message");
                if(message != null) {
            %><span>
                    <%= message %>
                </span><%
            }
        %>

            <form id="Login" method="post">

                <div class="form-group">


                    <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email Address">

                </div>

                <div class="form-group">

                    <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">

                </div>
                <button type="submit" class="btn btn-primary">Login</button>

            </form>
        </div>
    </div>
</div>
</body>
</html>