package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;

import com.itdr.service.ProductService;
import com.itdr.utils.PathUtil1;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/manage/product/*")
public class ProductsController extends HttpServlet {
    private ProductService ps = new ProductService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取路径信息
        String pathuir = request.getRequestURI();
        String path = PathUtil1.getPath(pathuir);
        ResponseCode rs= null;
        //判断请求
        switch (path){
            case  "list":
                rs = listDo (request);
            case "putaway":
                rs = putawayDo(request);
        }
        //返回响应数据
        response.getWriter().write(rs.toString());
    }

    private ResponseCode listDo (HttpServletRequest request){
        //创建统一返回值对象
        ResponseCode rs = new ResponseCode();
        //获取session登录状态
        HttpSession session = request.getSession();
        //查看是否登录如果已经登录赋值给Users
        Users user = (Users)session.getAttribute("user");

        if( user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
            return rs;
        }
        String pageSize = request.getParameter("paseSize");
        String pageNum = request.getParameter("pageNum");

        rs = ps.selectAll(pageNum,pageSize);
        return rs;


    }
    //商品上架或者下架
    private ResponseCode putawayDo(HttpServletRequest request){
        //获取pid和要修改的状态
        String pid = request.getParameter("pid");
        String status = request.getParameter("status");
        ResponseCode rs = ps. putawayOne(pid,status);
        return rs;
    }
}