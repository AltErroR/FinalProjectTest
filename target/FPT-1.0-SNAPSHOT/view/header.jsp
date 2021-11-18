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
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">

</head>
<style>
    #head {


        position: fixed;
        top:0%;
        width:100%;
        background-color: #eaeaea;
        opacity: 1;
    }
</style>
<body>
<form id="head">
<h1 style="text-align: center"><fmt:message key="beautySalon"/></h1>
<c:if test="${!sessionScope.role.equals('user')}">
<%--    <a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message--%>
<%--            key="mainPage"/></a>&emsp;--%>
    &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message
            key="mainPage"/></a>&emsp;

</c:if>
<c:if test="${userLoggedIn}">
    &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=logout"><fmt:message
            key="logout"/></a>&emsp;
    &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=feedback"><fmt:message
            key="feedbacks"/></a>&emsp;
</c:if>
<c:if test="${userLoggedIn ne true}">
    &emsp;<a style="alignment: left" href="view/authorization.jsp"><fmt:message key="login"/></a>&emsp;
</c:if>


<c:choose>
    <c:when test="${sessionScope.role.equals('user')}">
        &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=mainPage"><fmt:message
                key="userHome"/></a>&emsp;
        &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=orders"><fmt:message
                key="feedback"/></a>&emsp;
        &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/view/booking.jsp"><fmt:message
                        key="book"/></a>&emsp;
        &emsp;<input style="alignment: right" maxlength="50" name="wallet" readonly value="${sessionScope.wallet/100}"/>&emsp;
    </c:when>

    <c:when test="${sessionScope.role.equals('master')}">
        &emsp;<a style="alignment: left"
           href="${pageContext.request.contextPath}/controller?command=masterHomeInit"><fmt:message
                key="masterHome"/></a>&emsp;
    </c:when>

    <c:when test="${sessionScope.role.equals('admin')}">
        &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=adminHomeInit"><fmt:message
                key="adminHome"/></a>&emsp;
        &emsp;<a style="alignment: left" href="${pageContext.request.contextPath}/controller?command=payment"><fmt:message
                key="payorder"/></a>&emsp;
    </c:when>
</c:choose>

    <form action="${pageContext.request.contextPath}/controller" method="post">
        <button type="submit" name="language" value="en">EN</button>
        <button type="submit" name="language" value="uk">UA</button>
        <input type="hidden" name="command" value="changeLanguage"/>
    </form>

    <br>
    <br>
</form>
<br><br><br>
<hr color="#ad4511">
<hr color="#11a4ad">
<br><br>
</body>
</html>