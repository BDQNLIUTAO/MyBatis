package cn.happy.servlet;


import cn.happy.entity.Book;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/5.
 */
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String uname=request.getParameter("uname");
        if(uname.equals("admin")){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }*/
        List<Book> list=new ArrayList<Book>();
        Book book1=new Book();
        book1.setBookName("平凡的世界");
        book1.setBookPrice(80);
        Book book2=new Book();
        book2.setBookName("解忧杂货店");
        book2.setBookPrice(30);
        Book book3=new Book();
        book3.setBookName("活着");
        book3.setBookPrice(30);
        list.add(book1);
        list.add(book2);
        list.add(book3);
        String json = JSON.toJSONString(list);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
