<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>order histories</title>
</head>
<style>
    tr{
        text-align: center;
    }
    a{
        color: green;
    }
</style>
<body>
<div>
    <h1>order histories</h1>
    <c:choose>
        <c:when test="${!empty histories}">
            <table>
                <tr>
                    <th>date</th>
                    <th>orderer</th>
                    <th>address</th>
                    <th>phone_number</th>
                    <th>product</th>
                </tr>
                <c:forEach var="history" items="${histories}">
                    <tr>
                        <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${history.created_At}"/></td>
                        <td>${history.orderer_name}</td>
                        <td>${history.orderer_address}</td>
                        <td>${history.orderer_phone_number}</td>
                        <td>
                            <a href="<c:url value='/store/detail?product=${history.name}&sign=${history.id}'/>">
                                ${history.name}
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h2>history does not exist</h2>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
