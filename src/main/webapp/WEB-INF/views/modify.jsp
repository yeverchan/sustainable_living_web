<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>${product.name} modify</title>
</head>
<body>
<form:form modelAttribute="">
    <input type="text" name="product_name" value="${product.name}">
    <input type="text" name="product_price" value="${product.price}">
    <textarea>${product.description}</textarea>
    <button type="submit">submit</button>
</form:form>
</body>
</html>
