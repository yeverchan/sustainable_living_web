<%--
  Created by IntelliJ IDEA.
  User: yechan
  Date: 2022/03/24
  Time: 8:15 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>purchase</title>
</head>
<body>
<form name="form" id="form" method="post">
    <input type="text" name="ordererName">
    <input type="text" name="ordererAddress">
    <input type="text" name="ordererPhone">

    <input type="button" onClick="getAddr();" value="주소검색하기"/>
</form>
</body>
</html>