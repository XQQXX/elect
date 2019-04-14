package com.elect.action.main;

import com.elect.entity.Book;
import com.elect.entity.Product;
import com.elect.service.MainService;
import com.elect.service.impl.MainServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        预防乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        注入MainService
        MainService mainService=new MainServiceImpl();
        try {
//            首页推荐
            List<Book> recommend=mainService.recommend();
            request.getSession().setAttribute("recommend",recommend);
//            热销推荐
            List<Product> hotBook=mainService.hotBook();
            request.getSession().setAttribute("hotBook",hotBook);
//            最新上架
            List<Product> newBook=mainService.newBook();
            request.getSession().setAttribute("newBook",newBook);
//            所有图书
            List<Book> bookList=mainService.bookList();
            request.getSession().setAttribute("bookList",bookList);
            response.sendRedirect("main/main.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
