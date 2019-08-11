package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.OrderItemVoLists;
import com.itdr.pojo.Orders;

import java.util.List;

public class OrderService {
    OrderDao od = new OrderDao();
    public ResponseCode selectAll(String pageNum, String pageSize) {
        ResponseCode rs = new ResponseCode();

        //判断两个参数是不是空
        if (pageNum == null||pageNum.equals("")){
            pageNum ="1";
        }
        if (pageSize == null||pageSize.equals("")){
            pageNum ="1";
        }
        //转到集合里
        List<Orders> li = od.selectAll(pageNum,pageSize);
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//查询一个
    public ResponseCode selectOne(String oid) {
        ResponseCode rs = new ResponseCode();
        OrderItemVoLists o = od.selectOne(oid);
        rs.setData(o);
        rs.setStatus(0);
        return rs;
    }
}
