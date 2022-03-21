<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <th>description</th>
            <th>price</th>
            <th>writer</th>
            <th>date</th>
        </tr>
        <c:forEach var="product" items="${myProducts}">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.user_id}</td>
            <td>${product.created_At}</td>
            <td><button>modify</button></td><!--    modify  -->
            <td><button>remove</button></td><!--    remove  -->
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
