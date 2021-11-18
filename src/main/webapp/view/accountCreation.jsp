
<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="account creation"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div style="text-align: center;"/>
    <br><br><br>
    <h1><fmt:message key="sign up"/></h1>
    <p><fmt:message key="please fill form for registration"/>.</p>
    <br>
    <form action="${pageContext.request.contextPath}/controller?command=creation" method="POST">
        <input type="text" placeholder=<fmt:message key="enter email"/> name="email" required
               pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ.]{1,15}[@][0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{1,10}[.][0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{1,4}"><br><br>
        <input type="text" placeholder=<fmt:message key="enter login"/> name="login" required><br><br>
        <input type="password" placeholder=<fmt:message key="enter password"/> name="password" required
               minlength="6" maxlength="20" size="20" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{6,20}"><br><br>
        <input type="password" placeholder=<fmt:message key="repeat password"/> name="password-repeat" required
               minlength="6" maxlength="20" size="20" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇ]{6,20}"><br><br>
        <h7><fmt:message key="user"/></h7>
        <input name="role" type="radio" value="user"><br>
        <h7><fmt:message key="master"/></h7>
        <input name="role" type="radio" value="master"><br><br>
        <input type="submit" value="<fmt:message key="create account"/>"><br><br><br>
        <a href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message key="back"/></a>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
