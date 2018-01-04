package cn.happy.day04annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
public class ArgumentController {
    //参数自动装配
    @RequestMapping("/login")
    public String login(String name){
        System.out.println(name);
        return "/index.jsp";
    }
    //对象自动装配
    @RequestMapping("/login2")
    public String login2(UserInfo user){
        System.out.println(user.getName());
        return "/index.jsp";
    }
    //域属性自动装配
    @RequestMapping("/login3")
    public String login3(UserInfo user){
        System.out.println("您的用户名是："+user.getName()+"\t您喜爱的图书是："+user.getBook().getBookname());
        return "/index.jsp";
    }
    //集合自动装配
    @RequestMapping("/listArgument")
    public String listArgument(UserInfo user){
        System.out.println("您的用户名是："+user.getName()+"\t您喜爱的图书是："+user.getBooks().get(0).getBookname());
        return "/index.jsp";
    }
}
