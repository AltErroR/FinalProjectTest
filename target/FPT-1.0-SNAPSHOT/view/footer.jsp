<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
</head>
<style>
    #info {

        height: 75px;
        position: fixed;
        bottom:0;
        width:100%;
        background-color: #eaeaea;
        opacity: 1;
    }
</style>
<body>
<footer id="info">
    <br>
    <p style="text-align: center"><fmt:message key="all rights reserved"/></p>
</footer>
</body>
</html>
