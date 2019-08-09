<%--
  Created by IntelliJ IDEA.
  User: Xiaoyu
  Date: 2019/8/7
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>商品目录</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>status</th>
        <th>price</th>
    </tr>
    <c:forEach items="${pli.data}" var="ps">
        <tr>
            <th>${ps.id}</th>
            <th>${ps.name}</th>
            <th>${ps.status}</th>
            <th>${ps.price}</th>
             <th><a href="/manage/product/putaway.do?pid=${ps.id}&status=0">上架</a></th>
            <th><a href="/manage/product/putaway.do?pid=${ps.id}&status=1">下架</a></th>
        </tr>
    </c:forEach>
</table>
</body>
</html>