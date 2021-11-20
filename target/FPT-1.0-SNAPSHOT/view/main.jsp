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
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">

    <title><fmt:message key="mainPage"/></title>
</head>
<body>

<jsp:include page="header.jsp"/>

<div style="text-align: center">
    &emsp; <a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster"><fmt:message key="master"/></a>&emsp;
    <a href="${pageContext.request.contextPath}/controller?command=mainPageByRating"><fmt:message key="rate"/></a>&emsp;
    <a href="${pageContext.request.contextPath}/controller?command=mainPageByService"><fmt:message key="service"/></a>&emsp;
    <hr>
</div>

<div class="well">
    <table align="center" style="width:70%; text-align: center" class="table">
        <thead>

        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th><fmt:message key="master"/></th>
            <th><fmt:message key="service"/></th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody>
<%--        <c:if test="${masterServiceList!=null&&masterServiceList.size()>0}">--%>
<%--            <c:out value="${masterServiceList}"/><br>--%>
<%--            <c:out value="${sessionScope.masterServiceList}"/>--%>
            <c:forEach var="msv" items="${sessionScope.masterServiceList}">
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <td> ${msv.masterLogin}</td>
                    <td>${msv.serviceName}</td>
                </tr>

            </c:forEach>
<%--        </c:if>--%>
<%--        <c:if test="${masterServiceList==null}">null <c:out value="${masterServiceList}"/><br> <c:out value="${sessionScope.masterServiceList}"/></c:if>--%>
<%--        <c:if test="${masterServiceList.size()<=0}">size 0 <c:out value="${masterServiceList}"/> <br><c:out value="${sessionScope.masterServiceList}"/></c:if>--%>
        </tbody>
    </table>
</div>

<div class="pagination">
    <ul>
        <c:if test="${currentPage != 1}">

            <c:if test="${sortBy.equals('master')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('service')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByService&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('id')}">
                <li><a href="${pageContext.request.contextPath}/controller?command=mainPage&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('rating')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByRating&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('masterName')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('serviceName')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByServiceName&page=${currentPage - 1}"><fmt:message key="previous page"/></a>
                </li>
            </c:if>
        </c:if>

        <c:if test="${currentPage le noOfPages}">

            <c:if test="${sortBy.equals('master')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByMaster&page=${currentPage + 1}">Next</a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('service')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByService&page=${currentPage + 1}">Next</a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('id')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPage&page=${currentPage + 1}"><fmt:message key="next page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('rating')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByRating&page=${currentPage + 1}"><fmt:message key="next page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('masterName')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin&page=${currentPage + 1}"><fmt:message key="next page"/></a>
                </li>
            </c:if>

            <c:if test="${sortBy.equals('serviceName')}">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?command=mainPageByServiceName&page=${currentPage + 1}"><fmt:message key="next page"/></a>
                </li>
            </c:if>

        </c:if>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/controller?command=mainPageByMasterLogin" method="post">
    <input name="master" type="text" value="" placeholder=<fmt:message key="input master"/>
           maxlength="45" size="30" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{2,45}"/>&emsp;
    <input type="submit" value="<fmt:message key="find by master"/>"><br>
</form>

<form action="${pageContext.request.contextPath}/controller?command=mainPageByServiceName" method="post">
    <input name="service" type="text" value="" placeholder=<fmt:message key="input service"/>
           maxlength="45" size="30" pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{2,45}"/>&emsp;
    <input type="submit" value="<fmt:message key="find by service"/>"><br>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>
