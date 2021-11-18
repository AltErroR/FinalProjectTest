<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<!DOCTYPE html>
<html >
<head>
    <title><fmt:message key="wellcome"/></title>
</head>
<body>

<jsp:include page="view/header.jsp"/>
<h1 align="center"><fmt:message key="wellcome message"/>
</h1>
<br/>
<jsp:include page="view/footer.jsp"/>
</body>
</html>