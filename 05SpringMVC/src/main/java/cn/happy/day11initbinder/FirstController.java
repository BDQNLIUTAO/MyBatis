package cn.happy.day11initbinder;

import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/4.
 */
@Controller
public class FirstController {
   /* @InitBinder
    public void initbinder(WebDataBinder binder){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }*/
   @InitBinder
    public void initbinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new MyDateEditor());
    }
    @RequestMapping("/first")
    public String doFirst(Date birthday,int age){
        System.out.println(birthday+"==============");
        System.out.println(age+"================");
        return "/second.jsp";
    }
}
