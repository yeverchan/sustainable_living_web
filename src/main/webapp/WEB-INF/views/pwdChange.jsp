<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/commons.css"/>">
</head>
<body>
<div>
    <form:form modelAttribute="pwdChange">
        <div class="error_msg"><form:errors path="current"/></div>
        <label for="current">current password</label>
        <input type="password" name="current" id="current" placeholder="current password" value="${pwd.current}"/>

        <div class="error_msg"><form:errors path="newPwd"/></div>
        <label for="newPwd">new password</label>
        <input type="password" name="newPwd" id="newPwd" placeholder="new password" value="${pwd.newPwd}"/>

        <div class="error_msg"><form:errors path="checkNewPwd"/></div>
        <label for="checkNewPwd">check new password</label>
        <input type="password" name="checkNewPwd" id="checkNewPwd" placeholder="check new password" value="${pwd.checkNewPwd}"/>

        <button type="submit">change</button>
    </form:form>

    <c:if test="${!empty pageContext.request.getSession(false).getAttribute('com')}">
        <script type="text/javascript">
            alert("complete");
        </script>
        ${pageContext.request.getSession(false).removeAttribute('com')}
    </c:if>
</div>
</body>
</html>
