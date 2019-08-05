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

    public ResponseCode  putawayOne(String pid, String status) {
        ResponseCode rs = new ResponseCode();
        if (pid == null || pid.equals("") || status == null || status.equals("")) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //转换字符串
        Integer pidi = null;
        Integer statusi = null;
        try {
            pidi = Integer.parseInt(pid);
            statusi = Integer.parseInt(status);
        } catch (Exception e) {
            rs.setStatus(105);
            rs.setMag("非法参数");
            return rs;
        }
        Products p = pd. putawayone(pidi);
        //判断用户存在
        if (p == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setData(Const.USER_NO_MSG);
            return rs;
        }

        int row = pd.updateByStatusi(pidi,statusi);
        if (row <= 0) {
            rs.setStatus(106);
            rs.setMag("操作失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        return rs;
    }

}



