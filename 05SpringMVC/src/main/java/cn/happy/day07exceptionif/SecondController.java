package cn.happy.day07exceptionif;

import cn.happy.day07exceptionif.entity.UserInfo;
import cn.happy.day07exceptionif.exceptions.AgeException;
import cn.happy.day07exceptionif.exceptions.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
            throw new AgeException("年龄异常");
        }
        return "/index.jsp";
    }
}
