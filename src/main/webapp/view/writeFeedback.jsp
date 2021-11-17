<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 12.11.2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Feedback</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Feedback</h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="orders">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table>
            <tr>
                <td>Id</td>
                <td>Login</td>
                <td>Service</td>
                <td>Time</td>
                <td>Date</td>

            </tr>
            <c:forEach var="order" items="${ordersList}">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.masterLogin}</td>
                    <td>${order.serviceName}</td>
                    <td>${order.timeSlot}</td>
                    <td>${order.dateSlot}</td>
                </tr>
            </c:forEach>

        </table>
        <br><br>
    </div>
</form>
<form action="${pageContext.request.contextPath}/controller?command=feedbackWrite" method="POST">
    <input type="hidden" name="command" value="feedbackWrite">
    <div>
        <div style="text-align: center;"/>
        <textarea rows="7" cols="80" name="message" placeholder="Input message, if you will">
        </textarea><br><br>
        <input type="text" placeholder="Input master" name="master" required/><br><br>
        <label for="rate">Which mark would you leave ?</label><br>
        <select name="rate" id="rate" multiple>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        <br><br>
        <input type="submit" value="Submit">

    </div>
</form>
</body>
</html>
