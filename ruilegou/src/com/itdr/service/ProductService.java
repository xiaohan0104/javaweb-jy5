package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Products;

import java.util.List;

public class ProductService {
    ProductDao qd = new ProductDao();
    private ProductDao pd = new ProductDao();


    public ResponseCode selectAll(String pageNum, String pageSize) {
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }
        List<Products> li = pd.selectAll(pageNum, pageSize);
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }


    public ResponseCode  putawayOne(String pid) {
        ResponseCode rs = new ResponseCode();
        if (pid == null || pid.equals("") ) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //转换字符串
        Integer pidi = null;
        try {
            pidi = Integer.parseInt(pid);
        } catch (Exception e) {
            rs.setStatus(105);
            rs.setMag("非法参数");
            return rs;
        }
        Products p = pd. putawayone(pidi);
        //判断商品存在
        if (p == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setData(Const.USER_NO_MSG);
            return rs;
        }

        int row = pd.updateByStatusi(pidi);
        if (row <= 0) {
            rs.setStatus(106);
            rs.setMag("操作失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData("操作成功");
        return rs;
    }
    public ResponseCode  putawayOne2(String pid) {
        ResponseCode rs = new ResponseCode();
        if (pid == null || pid.equals("") ) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //转换字符串
        Integer pidi = null;
        try {
            pidi = Integer.parseInt(pid);
        } catch (Exception e) {
            rs.setStatus(105);
            rs.setMag("非法参数");
            return rs;
        }
        Products p = pd. putawayone(pidi);
        //判断商品存在
        if (p == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setData(Const.USER_NO_MSG);
            return rs;
        }

        int row = pd.updateByStatusii(pidi);
        if (row <= 0) {
            rs.setStatus(106);
            rs.setMag("操作失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData("操作成功");
        return rs;
    }

    public ResponseCode selectOneDO(String name) {
        ResponseCode rs = new ResponseCode();
        //转换字符串
//        Integer pidi = null;
//        try {
//            pidi = Integer.parseInt(pid);
//        } catch (Exception e) {
//            rs.setStatus(105);
//            rs.setMag("非法参数");
//            return rs;
//        }
        Products li = pd.selectOne(name);
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
}



