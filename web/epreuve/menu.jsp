<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/09/2018
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .questions{
            border: solid 1px;
            padding: 3px;
            width: 100px;
            background-color: lightgray;
        }
        .questions:hover {
            background-color: aqua;
        }
        #menuquestions{
            display: flex
        }
    </style>
</head>
<body>
    <h2>Questions</h2>
    <div id="menuquestions">
        <div class="questions">1</div>
        <div class="questions">2</div>
        <div class="questions">3</div>
    </div>
</body>
</html>