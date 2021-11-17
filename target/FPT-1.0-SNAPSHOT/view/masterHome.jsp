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
    <title>masterHome</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Schedule/ChangeStatus</h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="masterHomeInit">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table style="text-align: center" >
            <tr>
                <td>Order Id</td>
                <td>Service</td>
                <td>Time</td>
                <td>Date</td>
                <td>User Id</td>
                <td>Status</td>

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
<form action="${pageContext.request.contextPath}/controller?command=statusChange" method="POST">
    <div>
        <input type="text" name="orderId" value="" placeholder="Order id"
               maxlength="5" size="20" pattern="[0-9]{1,5}">
        <br><br>
        <label for="status">Status</label><br>
        <select name="status" id="status" multiple>
            <option value="in progress">in progress</option>
            <option value="done">done</option>
        </select>
        <input type="submit" value="Change status">

    </div>

</form>
</body>
</html>
