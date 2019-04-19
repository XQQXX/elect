package com.elect.action.order;

import com.elect.entity.Cart;
import com.elect.entity.Order;
import com.elect.entity.Receive_address;
import com.elect.service.CartService;
import com.elect.service.OrderService;
import com.elect.service.impl.CartServiceImpl;
import com.elect.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.order")
public class orderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        OrderService orderService=new OrderServiceImpl();
        CartService cartService=new CartServiceImpl();
        if(uri.equals("/buildOrder")){
            List<Cart> carts= (List<Cart>) request.getSession().getAttribute("cart");
            String receive_name=request.getParameter("receiveName");
            String full_address=request.getParameter("fullAddress");
            String postal_code=request.getParameter("postalCode");
            String mobile=request.getParameter("phone");
            String phone=request.getParameter("mobile");
            Order order=new Order();
            order.setReceive_name(receive_name);
            order.setPostal_code(postal_code);
            order.setFull_address(full_address);
            order.setMobile(mobile);
            order.setPhone(phone);
            try {
//                添加订单
                int order_id = orderService.addOrder(carts,order);
//                添加订单商品
                orderService.addItem(carts,order_id);
//                查询订单
                order=orderService.findOrder(order_id);
//                添加地址
                Receive_address receive_address=new Receive_address(carts.get(0).getUser_id(),receive_name,full_address,postal_code,mobile,phone);
                orderService.addAddress(receive_address);
//                下单成功，删除购物车内容
                cartService.delCart(carts.get(0).getUser_id(),1);
                request.getSession().setAttribute("order",order);
                request.getRequestDispatcher("../order/order_ok.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
