<%--
  Created by IntelliJ IDEA.
  User: Xiaoyu
  Date: 2019/8/8
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<table>
    <tr>
        <th>订单号</th>
        <th>商品名称</th>
        <th>价格</th>
    </tr>


        <tr>
            <th>${ooo.data.orderNo}</th>
            <th>${ooo.data.productName}</th>
            <th>${ooo.data.totalPrice}</th>
        </tr>

</table>
</body>
</html>
