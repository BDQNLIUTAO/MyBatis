package cn.happy.day06exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/3.
 */
@Controller
public class FirstController {
    @RequestMapping("list")
   public String doFirst(){
       //构造异常
       int result=5/0;
       return "/index.jsp";
   }

}
