<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="id" value="${pageContext.request.session.getAttribute('auth')}"/>
<c:set var="loginCheck" value="${id != null ? 'wellcome ' += id.id : 'please login'}"/>
<html>
<head>
    <title>home</title>
</head>
<body>
<ul>
    <ul>
        <li><a href="<c:url value='/login'/>">login</a></li>
        <li><a href="<c:url value='/register/create'/>">create account</a></li>
        <h1>${loginCheck}</h1>
    </ul>
</ul>
</body>
</html>
