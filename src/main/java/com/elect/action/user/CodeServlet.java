package com.elect.action.user;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/code.code")
public class CodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        生成验证码
        request.setCharacterEncoding("utf-8");
        response.setContentType("image/JPEG");
        BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_BGR);
        Graphics g=image.getGraphics();
        Random ran=new Random();
        g.drawRect(0, 0, 80, 30);
        String str="0123456789";
        for(char i='A';i<='Z';i++){
            str+=i;
        }
        String code="";
        for(int i=0;i<5;i++){
            code+=str.charAt(ran.nextInt(str.length()));
        }
        g.setColor(new Color(ran.nextInt(255), ran.nextInt(255),ran.nextInt(255)));
        g.setFont(new Font("宋体", Font.BOLD, 18));
        g.drawString(code, 16, 20);
        for(int i=0;i<5;i++){
            g.setColor(new Color(ran.nextInt(255), ran.nextInt(255),ran.nextInt(255)));
            g.drawLine(ran.nextInt(80), ran.nextInt(30), ran.nextInt(80), ran.nextInt(30));
        }
        ImageIO.write(image, "JPEG",response.getOutputStream());
        request.getSession().setAttribute("code", code);
    }

}
