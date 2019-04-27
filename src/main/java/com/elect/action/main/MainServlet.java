package com.elect.action.main;

import com.elect.entity.Book;
import com.elect.entity.Category;
import com.elect.entity.Product;
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

@WebServlet("*.main")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        预防乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        注入MainService
        MainService mainService=new MainServiceImpl();
        AdminService adminService=new AdminServiceImpl();
        String uri=request.getRequestURI();
        uri=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
        if(uri.equals("/main")) {
            try {
//                首页推荐
                List<Book> recommend = mainService.recommend();
                request.getSession().setAttribute("recommend", recommend);
//                热销推荐
                List<Product> hotBook = mainService.hotBook();
                request.getSession().setAttribute("hotBook", hotBook);
//                最新上架
                List<Product> newBook = mainService.newBook();
                request.getSession().setAttribute("newBook", newBook);
//                图书分类
                Map<Category, List<Category>> category = mainService.Category();
                request.getSession().setAttribute("category", category);
//                显示所有图书
                List<Book> bookList = mainService.bookList();
                request.getSession().setAttribute("bookList",bookList);
                response.sendRedirect("main/main.jsp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        图书分类
        if(uri.equals("/list")){
            try {
                int id=Integer.parseInt(request.getParameter("id"));
                int parent_id=Integer.parseInt(request.getParameter("parent_id"));
                Category category=adminService.preEdit(parent_id);
//                显示分类栏
                Map<Category, List<Category>> categoryListMap= (Map<Category, List<Category>>) request.getSession().getAttribute("category");
                List<Category> categories=categoryListMap.get(category);
                request.getSession().setAttribute("categories", categories);
                request.getSession().setAttribute("name",category);
//                按分类显示图书
                int page=1;
                List<Book> bookCats=mainService.CateList(id);
                request.setAttribute("page",page);
                request.getSession().setAttribute("bookCats",bookCats);
                request.getRequestDispatcher("paging.main?page="+page).forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        分页
        if(uri.equals("/paging")){
                int page=Integer.parseInt(request.getParameter("page"));
                request.setAttribute("page",page);
                List<Book> bookCats= (List<Book>) request.getSession().getAttribute("bookCats");
                //分页
            try {
                bookCats=mainService.paging(page,bookCats);
                request.setAttribute("bookCat",bookCats);
                request.getRequestDispatcher("book_list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        book详情
        if(uri.equals("/detail")){
            int id=Integer.parseInt(request.getParameter("id"));
            try {
                Book book = mainService.detailBook(id);
                request.setAttribute("book",book);
                request.getRequestDispatcher("show_product.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
