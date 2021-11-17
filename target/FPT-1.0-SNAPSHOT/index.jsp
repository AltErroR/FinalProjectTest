<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Index</title>
</head>
<body>

<jsp:include page="view/header.jsp"/>
<h1><%= "Hello World!" %>
</h1>
<br/>
<%--<a href="${pageContext.request.contextPath}/controller">Hello EbaTb // not valid</a><br>--%>
<%--<a href="view/authorization.jsp">АВТОРИЗАЦИЯ НАХ</a><br><br>--%>
<%--<a href="${pageContext.request.contextPath}/controller?command=feedback">Відгуки</a><br><br>--%>
<%--<a href="${pageContext.request.contextPath}/controller?command=sendMail">message sanding</a><br><br>--%>
<jsp:include page="view/footer.jsp"/>
</body>
</html>