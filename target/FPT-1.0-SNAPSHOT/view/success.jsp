<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=success" method="POST" >
<div class="container">
    <div style="text-align: center;"/>
    <br><br><br>
    <h1>Success</h1>
    <p>Some message</p>
    <input type=submit name="submitbtn" value="OK">
</div>
</form>
</body>
</html>
