<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="auth" value="${pageContext.request.getSession(false).getAttribute('auth')}"/>
<c:set var="com" value="${pageContext.request.getSession(false).getAttribute('com')}"/>
<html>
<head>
    <title>Store Home</title>
    <link rel="stylesheet"  href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<div>
    <h1>product list</h1>
        <c:choose>
            <c:when test="${!empty Products}">
                <table>
                    <tr>
                        <th>name</th>
                        <th>description</th>
                        <th>price</th>
                        <th>writer</th>
                        <th>date</th>
                    </tr>
                    <c:forEach var="product" items="${Products}">
                        <tr>
                            <td>${product.name}</td>
                            <td>${product.description}</td>
                            <td>${product.price}</td>
                            <td>${product.user_id}</td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${product.created_At}"/></td>
                            <td id="${product.state eq 1 ? 'forSale' : 'soldOut'}">${product.state eq 1 ? 'For Sale' : 'Sold Out'}</td>
                            <td>
                                <a href="<c:url value="/store/detail?product=${product.name}&sign=${product.id}"/>">detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <h2> no items </h2>
            </c:otherwise>
        </c:choose>
</div>
<div>
        <c:choose>
            <c:when test="${empty auth}">
                ${pageContext.request.session.setAttribute('path', '/store/home')}
                <a href="<c:url value='/login'/>"><button>login</button></a>
            </c:when>
            <c:otherwise>
                <h3>my point : ${point}</h3>
            </c:otherwise>
        </c:choose>
</div>
<a href="<c:url value='/store/myInfo'/>">myInfo</a>
<c:if test="${!empty com}">
    <script type="text/javascript">
        alert("complete");
        ${pageContext.request.getSession(false).removeAttribute('com')}
    </script>
</c:if>
<c:if test="${!empty check && 'compleTx' eq check}">
    <script type="text/javascript">
        alert("transaction complete");
    </script>
</c:if>
</body>
</html>
