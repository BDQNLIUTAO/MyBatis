package cn.happy.day08exceptionannotation;

import cn.happy.day07exceptionif.entity.UserInfo;
import cn.happy.day07exceptionif.exceptions.AgeException;
import cn.happy.day07exceptionif.exceptions.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/11/3.
 */
@Controller
public class SecondController {
    @RequestMapping("firstExceptionSelf")
    public String doSecond(UserInfo info) throws Exception {
        if (!info.getName().equals("admin")){
            //用户输入的不是admin，抛出一个Name异常
            throw  new NameException("用户名异常");
        }
        if (info.getAge()>100){
            System.out.println("111111111");
            throw new AgeException("年龄异常");
        }
        return "/index.jsp";
    }
    @ExceptionHandler(Exception.class)
   public ModelAndView myannotation(Exception ex){
        System.out.println("2222222222222222");
       ModelAndView mv=new ModelAndView();
       //判断mv是否受NameException异常
       if (ex instanceof NameException){
           mv.addObject("ex",ex);
           mv.setViewName("/error/nameerrors.jsp");
       }
       if (ex instanceof AgeException){
           mv.addObject("ex",ex);
           mv.setViewName("/error/ageerrors.jsp");
       }
       return mv;
   }
}
