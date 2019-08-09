<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaoyu
  Date: 2019/8/8
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单列表</title>
</head>
<body>
<table>
    <tr>
        <th>订单号</th>
        <th>价格</th>
        <th>支付方式</th>
        <th>订单状态号</th>
        <th>支付状态</th>
        <th>付款时间</th>
        <th>发送时间</th>
        <th>结束时间</th>
        <th>关闭时间</th>
        <th>创建时间</th>
    </tr>
    <c:forEach items="${oli.data}" var="os">
        <tr>
            <th>${os.orderNo}</th>
            <th>${os.payment}</th>
            <th>${os.paymentTypeDesc}</th>
            <th>${os.status}</th>
            <th>${os.statusDesc}</th>
            <th>${os.paymentTime}</th>
            <th>${os.sendTime}</th>
            <th>${os.endTime}</th>
            <th>${os.closeTime}</th>
            <th>${os.createTime}</th>
            <th><a href="/manage/order/xq.do?oid=${os.orderNo}">详情</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
