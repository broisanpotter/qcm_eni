<%@ page import="entity.QuestionTirage" %><%--
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
</head>
<body>
    <div>
        <jsp:include page='menu.jsp' />
    </div>
    <div>
        <%=question.getQuestion().enonce%>
    </div>

</body>
</html>
