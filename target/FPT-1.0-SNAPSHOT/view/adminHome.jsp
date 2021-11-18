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
    <title><fmt:message key="admin Home"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 align="center"><fmt:message key="order change"/></h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="adminHomeInit">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table align="center" style="width:70%; text-align: center" class="table">
            <tr>
                <td><fmt:message key="order id"/></td>
                <td><fmt:message key="master"/> </td>
                <td><fmt:message key="service"/></td>
                <td><fmt:message key="time"/></td>
                <td><fmt:message key="date"/></td>
                <td><fmt:message key="user id"/></td>
                <td><fmt:message key="status"/></td>

            </tr>
            <c:forEach var="order" items="${ordersList}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.masterLogin}</td>
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
<form action="${pageContext.request.contextPath}/controller?command=orderChange" method="POST">
    <div align="center">
        <input type="text" name="orderId" value="" placeholder=<fmt:message key="input order id"/>
               maxlength="5" size="20" pattern="[0-9]{1,5}"required><br><br>
        <input name="date" type="text" value="" placeholder=<fmt:message key="input date"/> minlength="8"
               maxlength="10" size="20"pattern="[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}"required/><br><br>
        <input name="time" type="text" value=""  placeholder=<fmt:message key="input time"/> minlength="3"
               maxlength="5" size="20"pattern="[0-9]{1,2}[:][0-9]{1,2}"required/><br><br>
        <h7><fmt:message key="update order"/></h7>
        <input type="radio" name="status" value="update" /><br>
        <h7><fmt:message key="delete order"/></h7>
        <input type="radio" name="status" value="delete" /><br><br>
        <input type="submit" value="Change order">

    </div>

</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
