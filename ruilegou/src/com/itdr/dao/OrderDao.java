package com.itdr.dao;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.OrderItemVoLists;
import com.itdr.pojo.Orders;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    public List<Orders> selectAll(String pageNum, String pageSize) {
        //获取连接池
        ComboPooledDataSource c = PoolUtil.getCom();
        //JDBC处理SQL语句的类
        QueryRunner qr = new QueryRunner(c);
        //创建Sql语句
        String sql = "select * from orders";
        //创建订单集合存储
        List<Orders> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Orders>(Orders.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public OrderItemVoLists selectOne(String oid) {
        ComboPooledDataSource c = PoolUtil.getCom();
        QueryRunner rq = new QueryRunner(c);
        String sql = "select * from orderitemvolist where orderNo =? ";
        OrderItemVoLists o = null;
        try {
            o = rq.query(sql, new BeanHandler<OrderItemVoLists>(OrderItemVoLists.class),oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}
