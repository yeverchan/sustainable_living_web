<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="<c:url value="/login"/>" method="post">
    <div>
        <input type="text" name="id" placeholder="id">
        <input type="password" name="password" placeholder="password">
        <button>login</button>
    </div>
</form>
</body>
</html>
