<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>my info</title>
</head>
<body>
    <h1>id : ${auth.id}</h1>
    <h1>email : ${auth.email}</h1>
    <h1>name : ${auth.name}</h1>
    <h1>point : ${auth.amount}</h1>
    <a href="/manage/change"><button>Change Info</button></a>
    <a href="/manage/pwdChange"><button>change password</button></a>
</body>
</html>
