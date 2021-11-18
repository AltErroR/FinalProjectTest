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
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title><fmt:message key="feedback"/></title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 align="center"><fmt:message key="feedback"/></h2>
<form action="${pageContext.request.contextPath}/controller" method="POST">
    <input type="hidden" name="command" value="orders">
    <div>
        <div style="text-align: center;"/>
        <br><br>
        <table align="center" style="width:70%; text-align: center" class="table">
            <tr>
                <td><fmt:message key="id"/></td>
                <td><fmt:message key="login"/></td>
                <td><fmt:message key="service"/></td>
                <td><fmt:message key="time"/></td>
                <td><fmt:message key="date"/></td>

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
        <textarea align="center" style="width:70%" rows="7" cols="80"  name="message" placeholder=<fmt:message key="input message"/>>
        </textarea><br><br>
        <input align="center"  type="text" placeholder=<fmt:message key="input master"/> name="master" required/><br><br>
        <label for="rate"><fmt:message key="which mark would you leave"/></label><br>
        <select style="alignment: center"   style="width:10%" name="rate" id="rate" multiple>
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
        <input align="center" type="submit" value="<fmt:message key="submit"/>">

    </div>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
