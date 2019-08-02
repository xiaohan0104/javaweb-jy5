package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.PathUtil1;
import com.sun.javafx.scene.shape.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manage/user/*")
public class UsersController extends HttpServlet {

    private UserService uc = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求路径信息
//        String pathInfo = request.getPathInfo();
        String pathInfo = request.getRequestURI();
        String path = PathUtil1.getPath(pathInfo);
        ResponseCode rs = null;
        //判断是什么请求
        switch (path){
            case  "list":
                rs = listDo(request);
                break;
            case  "login":
                rs = loginDo(request);
                break;
        }



         //返回响应数据
            response.getWriter().write(rs.toString());
    }
    //获取所有用户列表的请求
    private ResponseCode listDo(HttpServletRequest request){
        //获取参数
        ResponseCode rs = new ResponseCode();

        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("user");
        if (user == null){
            rs.setStatus(3);
            rs.setData("请登录后操作");
            return rs;
        }
        if (user.getType()!= 1){
            rs.setStatus(3);
            rs.setData("没有操作权限");
            return rs;
        }

        String pageSize = request.getParameter("paseSize");
        String pageNum = request.getParameter("pageNum");

      rs = uc.selectAll(pageNum,pageSize);

return rs;

    }
    private ResponseCode loginDo(HttpServletRequest request){
        //获取参数

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode rs = uc.selectOne(username, password);
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getData());

        //调用业务层处理业务

        return rs;
    }

}
