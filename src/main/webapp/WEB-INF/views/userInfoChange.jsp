<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>Change Info</title>
    <link rel="stylesheet"  href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<div>
    <form action="<c:url value="/manage/nameChange"/>" method="post">
        <div class="error_msg"><form:errors path="name"/></div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" value="${auth.name}"/>
        <button type="submit">change</button>
    </form>
</div>
<div>
    <form action="<c:url value="/manage/emailChange"/>" method="post">
        <div class="error_msg"><form:errors path="email"/></div>
        <label for="email">email</label>
        <input type="email" name="email" id="email" value="${auth.email}"/>
        <button type="submit">change</button>
    </form>

    <c:if test="${!empty com}">
        <script type="text/javascript">
            alert("complete");
        </script>
    </c:if>
</div>
<h1><a href="<c:url value="/"/>">home</a></h1>
</body>
</html>
