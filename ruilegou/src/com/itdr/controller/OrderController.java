package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.PathUtil1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/manage/order/*")
public class OrderController extends HttpServlet {
    OrderService os = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取路径
        String pathuir = request.getRequestURI();
        String path = PathUtil1.getPath(pathuir);

        //创建统一返回值
        ResponseCode rs= null;
        //判断请求
        switch (path){
            case "list":
                listDo(request,response);
            break;
            case "xq":
                xqDo(request,response);
                break;
        }
    }

    private void listDo(HttpServletRequest request, HttpServletResponse response) {
        //创建统一返回对象和参数
        ResponseCode rs = new ResponseCode();

        String pageSize = request.getParameter("paseSize");
        String pageNum = request.getParameter("pageNum");
        //调用业务层查询全部方法
        rs = os.selectAll(pageNum,pageSize);

        //存到request领域
        request.setAttribute("oli",rs);

        //转发请求到网址
        try {
            request.getRequestDispatcher("/WEB-INF/orderlist.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void xqDo(HttpServletRequest request, HttpServletResponse response) {
        //创建统一返回对象和参数
        ResponseCode rs = new ResponseCode();

        String oid = request.getParameter("oid");
        //调用业务层查询一个商品方法
        rs = os.selectOne(oid);

        //存到request领域
        request.setAttribute("ooo",rs);

        //转发请求到网址
        try {
            request.getRequestDispatcher("/WEB-INF/orderone.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}