<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="master home"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 align="center">Schedule/ChangeStatus</h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="masterHomeInit">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table align="center" style="width:70%; text-align: center" class="table">
            <tr>
                <td><fmt:message key="order id"/></td>
                <td><fmt:message key="service"/></td>
                <td><fmt:message key="time"/></td>
                <td><fmt:message key="date"/></td>
                <td><fmt:message key="user id"/></td>
                <td><fmt:message key="status"/></td>

            </tr>
            <c:forEach var="order" items="${ordersList}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.serviceName}</td>
                    <td>${order.timeSlot}</td>
                    <td>${order.dateSlot}</td>
                    <td>${order.userId}</td>
                    <td>${order.status}</td>
                </tr>
            </c:forEach>

        </table>
        <br><br>
    </div>
</form>
<form  action="${pageContext.request.contextPath}/controller?command=statusChange" method="POST">
    <div align="center">
        <input  type="text" name="orderId" value="" placeholder=<fmt:message key="order id"/>
               maxlength="5" size="20" pattern="[0-9]{1,5}">
        <br><br>
        <label for="status"><fmt:message key="status"/></label><br>
        <select style="text-align: center" name="status" id="status" multiple>
            <option value="in progress"><fmt:message key="in progress"/></option>
            <option value="done"><fmt:message key="done"/></option>
        </select>
        <br>
        <input type="submit" value="<fmt:message key="change status"/>">
    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
