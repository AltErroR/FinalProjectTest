<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:38
  To change this template use File | Settings | File Templates.
"${pageContext.request.contextPath}/servlet
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="login"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/controller?command=login" method="POST" >
    <div>
        <div style="text-align: center;"/>
        <h1><fmt:message key="authorization"/></h1>
        <br>
        <input name="login" type="text" value=""  placeholder=<fmt:message key="enter login"/> required/><br>
        <br>
        <input name="password" type="password" value="" placeholder=<fmt:message key="enter password"/> required
               minlength="6"maxlength="20" size="20"pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{6,20}"/><br><br>
        <h7><fmt:message key="user"/></h7>
        <input name="role" type="radio" value="user"/><br>
        <h7><fmt:message key="master"/></h7>
        <input name="role" type="radio" value="master"/><br><br>
        <input type="submit" value=<fmt:message key="login"/>/><br><br><br>
        <a href="${pageContext.request.contextPath}/view/accountCreation.jsp"><fmt:message key="create account"/></a>
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
