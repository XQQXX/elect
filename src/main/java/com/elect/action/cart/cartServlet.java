package com.elect.action.cart;

import com.elect.entity.Cart;
import com.elect.entity.Product;
import com.elect.entity.User;
import com.elect.service.CartService;
import com.elect.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.cart")
public class cartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        CartService cartService = new CartServiceImpl();
//             显示购物车
        if (uri.equals("/cart")) {
            try {
                User user= (User) request.getSession().getAttribute("user");
                if(user==null){
                    request.getRequestDispatcher("../cart/cart_list.jsp").forward(request,response);
                }else {
                    List<Cart> cart = cartService.showCart(1, user.getId());
                    List<Cart> delCart = cartService.showCart(0, user.getId());
                    request.getSession().setAttribute("cart", cart);
                    request.getSession().setAttribute("delCart", delCart);
                    request.getRequestDispatcher("../cart/cart_list.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        购物车添加商品
        if (uri.equals("/shop")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int user_id=Integer.parseInt(request.getParameter("userId"));
            try {
                cartService.addCartBook(id,user_id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        删除恢复购物车
        if(uri.equals("/changeStatus")){
            int id = Integer.parseInt(request.getParameter("id"));
            int status=Integer.parseInt(request.getParameter("status"));
            try {
                cartService.changeStatus(id,status);
                request.getRequestDispatcher("cart.cart").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        改变商品数量
        if(uri.equals("/changeNum")){
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            int product_num=Integer.parseInt(request.getParameter("product_num"));
            try {
                cartService.changeNum(product_id,product_num);
                request.getRequestDispatcher("cart.cart").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
