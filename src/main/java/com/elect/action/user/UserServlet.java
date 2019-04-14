package com.elect.action.user;

import com.elect.entity.User;
import com.elect.service.UserService;
import com.elect.service.impl.UserServiceImpl;
import com.elect.util.RanCode;
import com.elect.util.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("*.user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        预防乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        得到请求地址并进行切割
        String uri=request.getRequestURI();
        uri=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
//        注入userService
        UserService userService=new UserServiceImpl();
        PrintWriter out=response.getWriter();
//        邮箱名验证
        if(uri.equals("/checkEmail")){
            try {
                if(userService.checkEmail(request.getParameter("email"))){
                    out.write("true");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        验证码验证
        if(uri.equals("/checkVerifyCode")){
            String code=(String)request.getSession().getAttribute("code");
            String verifyCode=request.getParameter("verifyCode");
            try {
                if(userService.checkCode(code,verifyCode)){
                    out.write("true");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        用户注册1----基本信息填写
        if(uri.equals("/register_form")){
            String email=request.getParameter("email");
            String nickname=request.getParameter("nickname");
            String password=request.getParameter("password");
            String uuid= RanCode.ranUUID();
            SendMail.sendMail(email,uuid);
            User user=new User(email,nickname,password,uuid);
            try {
                userService.RegistUser(user);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("verify_form.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

//        用户注册2----邮箱验证
        if(uri.equals("/verify_form")){
            String emailCode=request.getParameter("emailCode");
            User user=(User)request.getSession().getAttribute("user");
            try {
                if(userService.checkEmailCode(user.getEmail_verify_code(),emailCode)){
                    String last_login_time=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
                    String last_login_ip=request.getRemoteAddr();
                    user.setLast_login_ip(last_login_ip);
                    user.setLast_login_time(last_login_time);
                    user.setIs_email_verify("Y");
                    request.getSession().setAttribute("user",user);
                    userService.RegistUserDetil(user);
                    request.getRequestDispatcher("register_ok.jsp").forward(request,response);
                }else{
                    request.setAttribute("errorMsg","邮箱验证失败，请检查后重新输入");
                    request.getRequestDispatcher("verify_form.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        用户登录
        if(uri.equals("/login_form")){
            String email=request.getParameter("name");
            String password=request.getParameter("password");
            User u=new User();
            u.setEmail(email);
            u.setPassword(password);
            User user= null;
            try {
                user = userService.checkLogin(u);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user==null){
                request.setAttribute("login_error","邮箱或密码错误，请重新输入！");
                request.getRequestDispatcher("login_form.jsp").forward(request,response);
            }else{
                try {
                    if(user.getIs_email_verify().equals("Y")){
                        String last_login_time=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
                        String last_login_ip=request.getRemoteAddr();
                        user.setLast_login_ip(last_login_ip);
                        user.setLast_login_time(last_login_time);
                        try {
                            userService.RegistUserDetil(user);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        request.getSession().setAttribute("user",user);
                        response.sendRedirect("../main");
                    }else{
                        String uuid=RanCode.ranUUID();
                        SendMail.sendMail(user.getEmail(),uuid);
                        user.setEmail_verify_code(uuid);
                        request.getSession().setAttribute("user",user);
                        request.getRequestDispatcher("verify_form.jsp").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

//        用户退出
        if(uri.equals("/logout")){
            request.getSession().removeAttribute("user");
            response.sendRedirect("main.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
