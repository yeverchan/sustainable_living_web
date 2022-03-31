<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>point histories</title>
</head>
<style>
    tr{
        text-align: center;
    }
</style>
<body>
<div>
    <h1>point histories</h1>
    <c:choose>
        <c:when test="${!empty histories}">
            <table>
                <tr>
                    <th>date</th>
                    <th>service type</th>
                    <th>service description</th>
                    <th>amount</th>
                </tr>
                <c:forEach var="history" items="${histories}">
                    <tr>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${history.created_At}"/></td>
                        <td>${history.service_type}</td>
                        <td>${history.service_description}</td>
                        <td>${history.amount}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h2>history does not exist</h2>
        </c:otherwise>
    </c:choose>
</div>
<h1><a href="<c:url value="/"/>">home</a></h1>
</body>
</html>
