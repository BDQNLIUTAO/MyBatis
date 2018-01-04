package cn.happy.day09typeconverter.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/4.
 */
@Controller
public class FirstController {
    //表单填写错误，自动跳转到表单原始页面
    @ExceptionHandler(TypeMismatchException.class)  //不填默认为顶级异常
    public ModelAndView firstException(Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/typeconverter.jsp");
        return mv;
    }
    @RequestMapping("/first")
    public String doFirst(Date birthday,int age){
        System.out.println(birthday+"==============");
        System.out.println(age+"================");
        return "/second.jsp";
    }
}
