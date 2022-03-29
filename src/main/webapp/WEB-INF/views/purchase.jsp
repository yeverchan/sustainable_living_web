<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>purchase</title>
</head>
<body>
<h2>product info</h2>
<h3>${product.name}</h3>
<h3>${product.description}</h3>
<form:form modelAttribute="order">
    <label for=name>orderer name</label>
    <input type="text" id="name" name="ordererName">
    <label for=address>orderer address</label>
    <input type="text"id="address" name="ordererAddress">
    <label for=number>orderer phone number</label>
    <input type="text" id="number" name="ordererPhone">
    <input type="hidden" name="id" value="${product.id}">
    <input type="hidden" name="productName" value="${product.name}">
    <input type="hidden" name="ordererId" value="${auth.id}">
    <h3>${product.price}</h3>
    <button>purchase</button>
</form:form>
</body>
<c:if test="${!empty check && 'ntexso' eq check}">
    <script type="text/javascript">
        alert("this product has been deleted or Sold Out.");
        window.location.href = "<c:url value='/store/home'/>";
    </script>
</c:if>
</html>
