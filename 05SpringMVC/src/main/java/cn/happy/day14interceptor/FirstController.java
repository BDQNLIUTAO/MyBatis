package cn.happy.day14interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/8.
 */
@Controller
public class FirstController {
    @RequestMapping("/first")
    public String doFirst(){
        System.out.println("Handler");
        return "first.jsp";
    }
}
