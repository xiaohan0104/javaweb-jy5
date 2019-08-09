<%--
  Created by IntelliJ IDEA.
  User: Xiaoyu
  Date: 2019/8/6
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="css/Login.css">
<head>
    <title>登录</title>
</head>
<body>
<div id="H">
    <div id="H_1">
        <h>睿乐购后台管理系统</h>
        <form action="/manage/user/login.do" method="post">
            <input type="text" name="username" placeholder="请输入账号" class="H_11">
            <input type="password" name="password" placeholder="请输入密码" CLASS="H_11">
            <input type="submit" value="提交"  class="H_11">
        </form>
    </div>
</div>
</body>
</html>