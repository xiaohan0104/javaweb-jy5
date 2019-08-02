package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BaseResultSetHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public List<Users> selectAll(String pageNum, String pageSize) {
//        ComboPooledDataSource co = PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users";
        List<Users> li = null;
        try {
             li = qr.query(sql, new BeanListHandler<Users>(Users.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }

    public Users selectOne(String username, String password) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from users where uname = ? and psd = ?";
        Users u = null;
        try {
           u = qr.query(sql, new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}
