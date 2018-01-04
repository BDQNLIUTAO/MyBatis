package cn.happy.day03;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/10/29.
 */
public class MyViewResolverController extends MultiActionController {
    public String doFirst(HttpServletRequest request, HttpServletResponse response){
        return "jd";
    }
}
