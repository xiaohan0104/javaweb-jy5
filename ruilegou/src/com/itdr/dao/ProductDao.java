package com.itdr.dao;

import com.itdr.pojo.Products;
import com.itdr.utils.PathUtil1;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Products> selectAll(String pageNum, String pageSize) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from products";
        List<Products> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Products>(Products.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    //货品名商家情况得到一个商品
    public Products putawayone(Integer pid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from products where id = ? ";
        Products p = null;
        try {
            p = qr.query(sql, new BeanHandler<Products>(Products.class), pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public int updateByStatusi(Integer pid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = null;
            sql = "update products set status = 0 where id = ?";

        int row = 0;
        try {
            row = qr.update(sql, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
    public int updateByStatusii(Integer pid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = null;
        sql = "update products set status = 1 where id = ?";
        int row = 0;
        try {
            row = qr.update(sql, pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Products selectOne(String name) {
        //调用连接池方法
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from products where name = ? ";
        Products li = null;
        try {
            li = qr.query(sql, new BeanHandler<Products>(Products.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}