<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=error" method="POST" >
<div>
    <div style="text-align: center;"/>
    <br><br><br>
    <h1>Error !</h1>
    <p>"${ex}"</p>
    <input type=submit value="OK">
</div>
</form>
</body>
</html>
