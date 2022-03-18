<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>Change Info</title>
</head>
<body>
<div>
    <%-- There is no change.    --%>
    <form action="<c:url value="/manage/nameChange"/>" method="post">
        <div class="error_msg"><form:errors path="name"/></div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" value="${auth.name}"/>

        <input type="hidden" name="id" value="${auth.id}">
        <button type="submit">change</button>
    </form>
</div>
<div>
    <%-- There is no change. , duplicate e-mail  --%>
    <form action="<c:url value="/manage/emailChange"/>" method="post">
        <div class="error_msg"><form:errors path="email"/></div>
        <label for="email">email</label>
        <input type="text" name="email" id="email" value="${auth.email}"/>

        <input type="hidden" name="id" value="${auth.id}">
        <button type="submit">change</button>

    </form>
</div>

</body>
</html>
