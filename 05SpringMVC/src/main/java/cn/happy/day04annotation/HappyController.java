package cn.happy.day04annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller  //HappyController成为一个控制器
@RequestMapping(value = "/user",method ={ RequestMethod.POST,RequestMethod.GET})
public class HappyController {
    @RequestMapping("/{name}/{age}/dologin")
    public String dologin(@PathVariable("name") String uname, @PathVariable int age){
        System.out.println(uname);
        System.out.println(age);
        return "/index.jsp";
    }
    @RequestMapping("login")
    public String login(@RequestParam("name") String uname){
        System.out.println(uname);
        return "/index.jsp";
    }
    @RequestMapping("insert")
    public String insert(){
        return "/index.jsp";
    }
    @RequestMapping("second")
    public String second(){
        return "/second.jsp";
    }
    //代表0个或多个字符  以first结尾即可
    @RequestMapping("/*first")
    public String first(){
        return "/first.jsp";
    }
    //user和fiveth需要多级路径  或者没有路径也可以
    @RequestMapping("/**/fiveth")
    public String fiveth(){
        return "/first.jsp";
    }
    //user和sixth中间必须写一级路径  必须是一级
    @RequestMapping("/*/sixth")
    public String sixth(){
        return "/first.jsp";
    }
}
