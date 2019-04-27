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

@WebServlet("*.category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        AdminService adminService=new AdminServiceImpl();
        MainService mainService=new MainServiceImpl();
//      所有分类
        if(uri.equals("/categoryList")){
            try {
                Map<Category, List<Category>> category = mainService.Category();
                request.getSession().setAttribute("category", category);
                response.sendRedirect("admin/category/list.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        分类管理
        if(uri.equals("/category")) {
            String method = request.getParameter("method");
//            更新界面显示
            if (method.equals("preEdit")) {
                int id = Integer.parseInt(request.getParameter("cid"));
                try {
                    Category cate = adminService.preEdit(id);
                    request.setAttribute("cate", cate);
                    request.getRequestDispatcher("admin/category/mod.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            修改分类
            if (method.equals("update")) {
                int id = Integer.parseInt(request.getParameter("cid"));
                String name = request.getParameter("name");
                Category category = new Category();
                category.setName(name);
                category.setId(id);
                try {
                    adminService.updateCate(category);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                request.getRequestDispatcher("categoryList.category").forward(request, response);
            }
//            删除界面显示
            if (method.equals("preDelete")) {
                int id = Integer.parseInt(request.getParameter("cid"));
                try {
                    Category cate = adminService.preEdit(id);
                    request.setAttribute("cate", cate);
                    request.getRequestDispatcher("admin/category/del.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            删除分类
            if (method.equals("delete")) {
                int id = Integer.parseInt(request.getParameter("cid"));
                int parent_id=Integer.parseInt(request.getParameter("parent_id"));
                try {
                    adminService.deleteCate(id,parent_id);
                    request.getRequestDispatcher("categoryList.category").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            添加分类
            if (method.equals("add")){
                String name=request.getParameter("name");
                String en_name=request.getParameter("en_name");
                int parent_id=Integer.parseInt(request.getParameter("parent_id"));
                Category category=new Category();
                category.setName(name);
                category.setEn_name(en_name);
                category.setParent_id(parent_id);
                try {
                    adminService.addCate(category);
                    request.getRequestDispatcher("categoryList.category").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
