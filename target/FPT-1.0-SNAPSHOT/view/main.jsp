<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 09.11.2021
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en"/><%--"${language}"/>--%>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <title>Main</title>
</head>
<body>
<jsp:include page="header.jsp"/>


    <form action="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin" method="post">
        <input name="masterName" type="text" value="" placeholder="input master login"
               maxlength="45" size="30" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{2,45}"/>&emsp;
        <input type="submit" value="search by this master"><br>
    </form>

    <form action="${pageContext.request.contextPath}/controller?command=mainPageByServiceName" method="post">
        <input name="serviceName" type="text" value="" placeholder="input service"
               maxlength="45" size="30" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{2,45}"/>&emsp;
        <input type="submit" value="search by this service"><br>
    </form>
<form action="${pageContext.request.contextPath}/controller?command=mainPage" method="post">
    <input type="hidden" name="command" value="mainPage">
    <div style="text-align: center">

        &emsp; <a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster">master Login</a>&emsp;
        <a href="${pageContext.request.contextPath}/controller?command=mainPageByRating">master Rating</a>&emsp;
        <a href="${pageContext.request.contextPath}/controller?command=mainPageByService">service Name</a>&emsp;
        <hr>
    </div>
    <c:forEach var="msv" items="${masterServiceList}">
        <div style="text-align: center">
            <h3>${msv.masterLogin} : ${msv.serviceName}</h3>
            <hr>
        </div>
    </c:forEach>

</form>
<table align="center">
    <tr>
        <%--For displaying Previous link except for the 1st page --%>
        <c:if test="${currentPage != 1}">
        <c:if test="${sortBy.equals('master')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster&page=${currentPage - 1}"><
            Previous</a></td>

        </c:if>
        <c:if test="${sortBy.equals('service')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByService&page=${currentPage - 1}"><
            Previous</a></td>
        </c:if>
        <c:if test="${sortBy.equals('id')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPage&page=${currentPage - 1}"><
            Previous</a></td>
        </c:if>
        <c:if test="${sortBy.equals('rating')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByRating&page=${currentPage - 1}"><
            Previous</a></td>
        </c:if>
        <c:if test="${sortBy.equals('masterName')}">
        <td>
            <a href="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin&page=${currentPage - 1}"><
                Previous</a></td>
        </c:if>
        <c:if test="${sortBy.equals('serviceName')}">
        <td>
            <a href="${pageContext.request.contextPath}/controller?command=mainPageByServiceName&page=${currentPage - 1}"><
                Previous</a></td>
        </c:if>

        </c:if>
        <%--For displaying Next link --%>
        <c:if test="${currentPage le noOfPages}">

        <c:if test="${sortBy.equals('master')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster&page=${currentPage + 1}">Next
            ></a></td>

        </c:if>
        <c:if test="${sortBy.equals('service')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByService&page=${currentPage + 1}">Next
            ></a></td>
        </c:if>
        <c:if test="${sortBy.equals('id')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPage&page=${currentPage + 1}">Next ></a>
        </td>
        </c:if>
        <c:if test="${sortBy.equals('rating')}">
        <td><a href="${pageContext.request.contextPath}/controller?command=mainPageByRating&page=${currentPage + 1}">Next
            ></a></td>
        </c:if>
        <c:if test="${sortBy.equals('masterName')}">
        <td>
            <a href="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin&page=${currentPage + 1}">Next
                ></a></td>
        </c:if>
        <c:if test="${sortBy.equals('serviceName')}">
        <td>
            <a href="${pageContext.request.contextPath}/controller?command=mainPageByServiceName&page=${currentPage + 1}">Next
                ></a></td>
        </c:if>
        </c:if>
</table>
</body>
</html>
