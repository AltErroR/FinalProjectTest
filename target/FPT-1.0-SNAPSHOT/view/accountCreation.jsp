<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>

<div class="container">
    <div style="text-align: center;"/>
    <br><br><br>
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <br>
    <form action="${pageContext.request.contextPath}/controller?command=creation" method="POST">
<%--        <input type="hidden" name="command" value="creation">--%>
        <input type="text" placeholder="Enter Email" name="email" required
               pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ.]{1,15}[@][0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{1,10}[.][0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{1,4}"><br><br>
        <input type="text" placeholder="Enter Login" name="login" required><br><br>
        <input type="password" placeholder="Enter Password" name="password" required
               minlength="6" maxlength="20" size="20" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{6,20}"><br><br>
        <input type="password" placeholder="Repeat Password" name="password-repeat" required
               minlength="6" maxlength="20" size="20" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{6,20}"><br><br>
        <h7>User</h7>
        <input name="role" type="radio" value="user"><br>
        <h7>Master</h7>
        <input name="role" type="radio" value="master"><br><br>
        <input type="submit" value="Create account"><br><br><br>
        <a href="${pageContext.request.contextPath}/controller?command=mainPage">Back</a>
    </form>
</div>
</body>
</html>
