<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>My info</title>
    <link rel="stylesheet"  href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<c:choose>
    <c:when test="${!empty myProducts}">
        <table>
            <tr>
                <th>name</th>
                <th>price</th>
                <th>date</th>
            </tr>
            <c:forEach var="product" items="${myProducts}">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
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
<a href="<c:url value='/product/addProduct'/>">Add a Product</a>
</body>
</html>
