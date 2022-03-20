<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet"  href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<form:form modelAttribute="login">
    <div>
        <div class="error_msg"><form:errors path="id"/></div>
        <input type="text" id="id" name="id" placeholder="id">
        <div class="error_msg"><form:errors path="password"/></div>
        <input type="password" id="password" name="password" placeholder="password">
        <button>login</button>
    </div>
</form:form>
<div class="error_msg">${message}</div>
<c:if test="${!empty pageContext.request.getSession(false).getAttribute('auth')}">
    <script type="text/javascript">
        window.location.href = '/';
    </script>
</c:if>
</body>
</html>
