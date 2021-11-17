<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminHome</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>OrderChange</h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="adminHomeInit">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table style="text-align: center" >
            <tr>
                <td>Order Id</td>
                <td>Master </td>
                <td>Service</td>
                <td>Time</td>
                <td>Date</td>
                <td>User Id</td>
                <td>Status</td>

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
    <div>
        <input type="text" name="orderId" value="" placeholder="Order id"
               maxlength="5" size="20" pattern="[0-9]{1,5}"required><br><br>
        <input name="date" type="text" value="" placeholder="input Date" minlength="8"
               maxlength="10" size="20"pattern="[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}"required/><br><br>
        <input name="time" type="text" value=""  placeholder="input Time" minlength="3"
               maxlength="5" size="20"pattern="[0-9]{1,2}[:][0-9]{1,2}"required/><br><br>
        <h7>Update order</h7>
        <input type="radio" name="status" value="update" /><br>
        <h7>Delete order</h7>
        <input type="radio" name="status" value="delete" /><br><br>
        <input type="submit" value="Change order">

    </div>

</form>
</body>
</html>
