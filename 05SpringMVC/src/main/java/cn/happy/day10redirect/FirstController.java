package cn.happy.day10redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/4.
 */
@Controller
public class FirstController {
    /*@RequestMapping("/first")
    public String dofirst(Model model){
        model.addAttribute("msg","太阳");
        //默认是转发到视图页面   有视图解析器
        return "second";
    }*/
   /* @RequestMapping("/third")
    public String dothird(Model model){
        model.addAttribute("msg","太阳");
        //转发到视图页面   有视图解析器
        return "forward:second";
    }*/
    @RequestMapping("/four")
    public String dofour(Model model){
        model.addAttribute("msg","太阳");
        //重定向到视图页面   有视图解析器
        return "redirect:second";
    }
    @RequestMapping("/second")
    public String dosecond(Model model){
        model.addAttribute("msg","太阳");
        return "/index.jsp";
    }
}
