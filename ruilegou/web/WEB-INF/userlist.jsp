<%--
  Created by IntelliJ IDEA.
  User: Xiaoyu
  Date: 2019/8/6
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
${uli}

<table>
    <tr>
        <th>ID</th>
        <th>登录名</th>
        <th>密码</th>
        <th>电话</th>
        <th>权限</th>
        <th>状态</th>


    </tr>
    <c:forEach items="${uli.data}" var="us">
        <tr>
            <th>${us.uname}</th>
            <th>${us.id}</th>
            <th>${us.psd}</th>
            <th>${us.tel}</th>
            <th>${us.type}</th>
            <th>${us.stats}</th>
            <th><a href="/manage/user/disableuser.do?uid=${us.id}">禁用</a></th>
        </tr>

    </c:forEach>
</table>

</body>
</html>
