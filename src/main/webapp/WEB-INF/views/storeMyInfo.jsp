<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>My info</title>
</head>
<body>
<%--    my info     --%>

<%--    my proudct    --%>
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
                    <td>${product.created_At}</td>
                    <td>
                        <a href="<c:url value="/product/detail?product=${product.name}"/>">detail</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <h2> no items </h2>
    </c:otherwise>
</c:choose>
<a href="<c:url value='/store/addProduct'/>">Add a Product</a>
</body>
</html>
