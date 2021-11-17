<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/> <%--"${language}" --%>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center"><fmt:message key="beautySalon"/></h1>
<c:if test="${!sessionScope.role.equals('user')}">
<%--    <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message--%>
<%--            key="mainPage"/></a>&emsp;--%>
    <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message
            key="mainPage"/></a>&emsp;

</c:if>
<c:if test="${userLoggedIn}">
    <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
            key="logout"/></a>&emsp;
    <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=feedback"><fmt:message
            key="feedbacks"/></a>&emsp;
</c:if>
<c:if test="${userLoggedIn ne true}">
    <a style="alignment: left" href="view/authorization.jsp"><fmt:message key="login"/></a>&emsp;
</c:if>

<c:choose>
    <c:when test="${sessionScope.role.equals('user')}">
        <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message
                key="userHome"/></a>&emsp;
        <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=orders"><fmt:message
                key="feedback"/></a>&emsp;
                <a style="alignment: left" href="${pageContext.request.contextPath}/view/booking.jsp"><fmt:message
                        key="book"/></a>&emsp;
        <input style="alignment: right" maxlength="50" name="wallet" readonly value="${sessionScope.wallet/100}"/>&emsp;
    </c:when>

    <c:when test="${sessionScope.role.equals('master')}">
        <a style="alignment: left"
           href="${pageContext.request.contextPath}/controller?command=masterHomeInit"><fmt:message
                key="masterHome"/></a>&emsp;
    </c:when>

    <c:when test="${sessionScope.role.equals('admin')}">
        <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=adminHomeInit"><fmt:message
                key="adminHome"/></a>&emsp;
        <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=payment"><fmt:message
                key="payorder"/></a>&emsp;
    </c:when>
</c:choose>
<br><br>
<hr color="#ad4511">
<hr color="#11a4ad">
<br><br><br>
</body>
</html>