<%--
  Created by IntelliJ IDEA.
  User: Acccvor
  Date: 2023/5/17
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addUser</title>
</head>
<body>
<form action="/saveUser.do">
    <input type="text" name="username">
    <input type="text" name="address">
    <input type="submit" value="保存">
</form>
</body>
</html>