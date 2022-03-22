<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>${product.name}</title>
</head>
<body>
<div>
    <h3 name="product_name">${product.name}</h3>
    <h3 name="product_price">${product.price}</h3>
    <h3 name="product_created">${product.created_At}</h3>

</div>
<div>
    <h3 name="product_description">${product.description}</h3>
</div>
<%--if writer == writer--%>
<c:choose>
    <c:when test="${auth.id eq product.user_id}">
        <div>
            <a href="<c:url value='/product/modify?product=${product.name}'/>"><button>modify</button></a>
            <button>remove</button>
        </div>
    </c:when>
</c:choose>
</body>
</html>
