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

    public ResponseCode selectOne(String pid, String status) {
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

        }
        Products p = pd.selectone(pidi, statusi);
        //判断用户存在
        if (p == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setData(Const.USER_NO_MSG);
        }
        if (statusi == 0) {
            if (p.getStatus() == 0) {
                rs.setStatus(Const.USER_ISNOPUTAWAY_CODE);
                rs.setData(Const.USER_ISNOPUTAWAY_MSG);
            } else {
                int row = pd.updateByStatusi(statusi);
                if (row <= 0) {
                    rs.setStatus(106);
                    rs.setMag("商品下架失败");

                }
                rs.setStatus(0);
                rs.setData(row);

            }
        }
        if (statusi == 1) {
            if (p.getStatus() == 1) {
                rs.setStatus(Const.USER_ISPUTAWAY_CODE);
                rs.setData(Const.USER_ISPUTAWAY_MSG);

            } else {
                int row = pd.updateByStatusi(statusi);
                if (row <= 0) {
                    rs.setStatus(106);
                    rs.setMag("商品上架失败");
                }
                rs.setStatus(0);
                rs.setData(row);

            }

        }
        return rs;
    }
}
