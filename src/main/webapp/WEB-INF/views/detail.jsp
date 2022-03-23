<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="auth" value="${pageContext.request.session.getAttribute('auth')}"/>
<html>
<head>
    <title>${product.name}</title>
</head>
<body>
<div>
    <h3 name="product_name">${product.name}</h3>
    <h3 name="product_price">${product.price}</h3>
    <h3 name="product_created"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${product.created_At}"/></h3>
</div>
<div>
    <h3 name="product_description">${product.description}</h3>
</div>
<c:choose>
    <c:when test="${!empty product && !empty auth && auth.id eq product.user_id}">
        <div>
            <a href="<c:url value='/product/modify?product=${product.name}&sign=${product.id}'/>"><button>modify</button></a>
            <form action="<c:url value='/product/removeProduct?name=${product.name}&id=${product.id}'/>" method="post">
            <button>remove</button>
            </form>
        </div>
    </c:when>
    <c:when test="${!empty check && 'nfoundpd' eq check}">
        <script type="text/javascript">
            alert("this product has been deleted or does not exist.");
            window.location.href = "<c:url value='/store/home'/>";
        </script>
    </c:when>
    <c:otherwise>
        <div>
            <button>purchase</button>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>
