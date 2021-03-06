<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${mode eq 'modify' ? "modify product" : "add product"}</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<form:form modelAttribute="product">
    <div class="error_msg"><form:errors path="name"/></div>
    <label for="name">name</label>
    <input type="text" id="name" name="name" placeholder="product name" value="${product.name}">
    <div class="error_msg"><form:errors path="price"/></div>
    <label for="price">price</label>
    <input type="text" id="price" name="price" placeholder="product price" value="${product.price}">
    <div class="error_msg"><form:errors path="description"/></div>
    <label for="description">description</label>
    <textarea type="text" id="description" name="description"
              placeholder="product description">${product.description}</textarea>
    <c:if test="${mode eq 'modify'}">
        <input type="hidden" name="id" value="${product.id}"/>
    </c:if>
    <button type="submit">submit</button>
    <div class="error_msg">${message}</div>
</form:form>

<script type="text/javascript">
<c:choose>
    <c:when test="${com eq 'com'}">
    alert("complete");
    window.location.href = "<c:url value='/store/myInfo'/>";
    </c:when>

    <c:when test="${com eq 'error'}">
    alert("error");
    </c:when>
</c:choose>
</script>
<h1><a href="<c:url value="/"/>">home</a></h1>
</body>
</html>
