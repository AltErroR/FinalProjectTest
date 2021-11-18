<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="success"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/controller?command=success" method="POST" >
<div class="container">
    <div style="text-align: center;"/>
    <br><br><br>
    <h1><fmt:message key="success"/></h1>
    <p><fmt:message key="success message"/></p>
    <input type=submit name="submitbtn" value="OK">
</div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
