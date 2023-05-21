<%--
  Created by IntelliJ IDEA.
  User: liwei
  Date: 2023/5/16
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>viewUser</title>
    <style>
        table,tr,th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>用户ID</th>
            <th>用户名</th>
            <th>地址</th>
            <th colspan="2">操作</th>
        </tr>
<%--        先从request找，如果找不到就继续从session找，如果还是找不到就从context继续找，如果找不到就不找了--%>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.username}</td>
                <td>${user.address}</td>
                <td>
                    <a href="/updateUser.do?id=${user.userId}">修改</a>
                </td>
                <td>
                    <a href="/deleteUser.do?id=${user.userId}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
