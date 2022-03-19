<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>create_account</title>
    <link rel="stylesheet"  href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<form:form modelAttribute="register">
    <div class="error_msg"><form:errors path="id"/></div>
    <label for="id">id</label>
    <input type="text" id="id" name="id" placeholder="id" value="${createTemp.id}">
    <div class="error_msg"><form:errors path="password"/></div>
    <label for="password">password</label>
    <input type="password" id="password" name="password" placeholder="password" value="${createTemp.password}">
    <div class="error_msg"><form:errors path="checkPassword"/></div>
    <label for="checkPassword">check password</label>
    <input type="password" id="checkPassword" name="checkPassword" placeholder="check password" value="${createTemp.checkPassword}">
    <div class="error_msg"><form:errors path="name"/></div>
    <label for="name">name</label>
    <input type="text" id="name" name="name" placeholder="name" value="${createTemp.name}">
    <div class="error_msg"><form:errors path="email"/></div>
    <label for="email">email</label>
    <input type="email" id="email" name="email" placeholder="email" value="${createTemp.email}">
    <button type="submit">submit</button>
    <div class="error_msg">${message}</div>
</form:form>

<c:if test="${!empty pageContext.request.getSession(false).getAttribute('com')}">
    <script type="text/javascript">
        alert("complete");
        window.location.href='/';
    </script>
    ${pageContext.request.getSession(false).removeAttribute('com')}
</c:if>
</body>
</html>
