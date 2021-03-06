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
    <div class="error_msg"><form:errors path="ordererName"/></div>
    <label for=name>orderer name</label>
    <input type="text" id="name" name="ordererName" value="${order.ordererName}">

    <div class="error_msg"><form:errors path="ordererAddress"/></div>
    <label for=address>orderer address</label>
    <input type="text"id="address" name="ordererAddress" value="${order.ordererAddress}">

    <div class="error_msg"><form:errors path="ordererPhone"/></div>
    <label for=number>orderer phone number</label>
    <input type="text" id="number" name="ordererPhone" value="${order.ordererPhone}">

    <input type="hidden" name="productId" value="${product.id}">
    <input type="hidden" name="productName" value="${product.name}">

    <h3>${product.price}</h3>
    <button>purchase</button>
</form:form>
<h1><a href="<c:url value="/"/>">home</a></h1>
</body>
<c:if test="${!empty check && 'ntexso' eq check}">
    <script type="text/javascript">
        alert("this product has been deleted or Sold Out.");
        window.location.href = "<c:url value='/store/home'/>";
    </script>
</c:if>
<c:if test="${!empty check && 'nenopp' eq check}">
    <script type="text/javascript">
        alert("insufficient points");
        window.location.href = "<c:url value="/store/detail?product=${product.name}&sign=${product.id}"/>";
    </script>
</c:if>
<c:if test="${!empty check && 'txerror' eq check}">
    <script type="text/javascript">
        alert("transaction error");
        window.location.href = "<c:url value="/store/detail?product=${product.name}&sign=${product.id}"/>";
    </script>
</c:if>
</html>
