<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:38
  To change this template use File | Settings | File Templates.
"${pageContext.request.contextPath}/servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/controller?command=login" method="POST" >
    <div>
        <div style="text-align: center;"/>
        <h1>Authorization</h1>
        <br>
        <input name="login" type="text" value=""  placeholder="input login" required/><br>
        <br>
        <input name="password" type="password" value="" placeholder="input password" required
               minlength="6"maxlength="20" size="20"pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{6,20}"/><br><br>
        <h7>User</h7>
        <input name="role" type="radio" value="user" /><br>
        <h7>Master</h7>
        <input name="role" type="radio" value="master" /><br><br>
        <input type="submit" value="Log in"><br><br><br>
        <a href="${pageContext.request.contextPath}/view/accountCreation.jsp">Create account</a>
    </div>
</form>

</body>
</html>
