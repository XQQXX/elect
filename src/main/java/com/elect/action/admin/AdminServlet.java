package com.elect.action.admin;

import com.elect.entity.Category;
import com.elect.service.AdminService;
import com.elect.service.MainService;
import com.elect.service.impl.AdminServiceImpl;
import com.elect.service.impl.MainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("*.admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        AdminService adminService=new AdminServiceImpl();
        MainService mainService=new MainServiceImpl();
//        管理员登录
        if(uri.equals("/login")){
                String name=request.getParameter("name");
                String password=request.getParameter("password");
            try {
                boolean flag=adminService.login(name,password);
                if(!flag){
                    String msg="账号或密码错误！";
                    request.setAttribute("msg",msg);
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }else{
//                    加载图书分类
                    request.getSession().setAttribute("adminName",name);
                    Map<Category, List<Category>> category = mainService.Category();
                    request.getSession().setAttribute("category", category);
                    request.getRequestDispatcher("admin/main.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
