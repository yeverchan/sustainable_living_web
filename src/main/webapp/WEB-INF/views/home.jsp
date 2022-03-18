<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="authCheck" value="${pageContext.request.session.getAttribute('auth')}"/>
<c:set var="greeting" value="${authCheck != null ? 'wellcome ' += authCheck.id : 'please login'}"/>
<c:set var="loginCheck" value="${authCheck != null ? 'logout ' : 'login'}"/>
<html>
<head>
    <title>home</title>
</head>
</head>
<body>
<ul>
    <ul>
        <li><a href="<c:url value="/${loginCheck}"/>">${loginCheck}</a></li>
        <li><a href="<c:url value='/register/create'/>">create account</a></li>
        <h1>${greeting}</h1>
    </ul>
</ul>

<li><a href="<c:url value='/manage/my'/>">test</a></li>
</body>
</html>
