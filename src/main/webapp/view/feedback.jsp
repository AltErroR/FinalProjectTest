<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="feedbacks"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 align="center">Feedbacks</h2>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="feedback">
    <table align="center" style="width:70%; text-align: center" class="table">
        <tr>
            <th><fmt:message key="id"/></th>
            <th><fmt:message key="user"/></th>
            <th><fmt:message key="master"/></th>
            <th><fmt:message key="rate"/></th>
            <th><fmt:message key="feedback"/></th>
        </tr>
        <tr>
            <c:forEach var="fv" items="${feedbackList}">
        <tr style="text-align: center">
                <td>${fv.id}</td>
                <td>${fv.userId}</td>
                <td>${fv.masterLogin}</td>
                <td>${fv.userRate}</td>
                <td>${fv.feedbackMessage}</td>
        </tr>
            </c:forEach>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
