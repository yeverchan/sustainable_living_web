<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        #error_msg{
            color: red;
        }
    </style>
    <title>create_account</title>
</head>
<body>
<form:form modelAttribute="register">
    <div id="error_msg"><form:errors path="id"/></div>
    <label for="id">id</label>
    <input type="text" id="id" name="id">
    <div id="error_msg"><form:errors path="password"/></div>
    <label for="password">password</label>
    <input type="password" id="password" name="password">
    <div id="error_msg"><form:errors path="checkPassword"/></div>
    <label for="checkPassword">check password</label>
    <input type="password" id="checkPassword" name="checkPassword">
    <div id="error_msg"><form:errors path="name"/></div>
    <label for="name">name</label>
    <input type="text" id="name" name="name">
    <div id="error_msg"><form:errors path="email"/></div>
    <label for="email">email</label>
    <input type="email" id="email" name="email">
    <button type="submit">submit</button>
</form:form>
<div>
</div>
</body>
</html>
