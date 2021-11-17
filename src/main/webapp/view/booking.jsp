<%--
  Created by IntelliJ IDEA.
  User: Dima
  Date: 11.11.2021
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/controller?command=booking" method="POST" />
<div style="text-align: center">
    <h4>Booking</h4><br>
    <p>get your date,time,master,service </p>
    <p>example 12.12.1212 and 12:12 </p>
    <input name="date" type="text" value="" placeholder="input Date" required minlength="8" maxlength="10" size="20"pattern="[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}"/><br><br>
    <input name="time" type="text" value=""  placeholder="input Time" required minlength="3" maxlength="5" size="20"pattern="[0-9]{1,2}[:][0-9]{1,2}"/><br><br>
    <input name="master" type="text" value=""  placeholder="input Master" required minlength="1" maxlength="45" size="45"pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{1,45}"/><br><br>
    <input name="service" type="text" value=""  placeholder="input Service" required minlength="1" maxlength="45" size="45"pattern="[0-9a-zA-Zа-яА-ЯюЮєЄїЇіІ]{1,45}"/><br><br>
    <input type="submit" value="Book">
</div>
</form>
</body>
</html>
