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
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Feedbacks</h2>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="feedback">
    <table style="width:70%">
        <tr>
            <th>Id</th>
            <th>User</th>
            <th>Master</th>
            <th>Rate</th>
            <th>Feedback</th>
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
</body>
</html>
