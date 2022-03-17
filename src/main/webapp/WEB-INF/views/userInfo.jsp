<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${auth.id}</h1>
    <h1>${auth.email}</h1>
    <h1>${auth.name}</h1>
    <h1>${auth.amount}</h1>
</body>
</html>
