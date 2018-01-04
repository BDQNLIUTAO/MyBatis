package cn.happy.day05return;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/2.
 */
@Controller
public class FirstController {
    //方法返回值  ---map
    @RequestMapping("/map")
    @ResponseBody
    public Object domap() throws IOException {
        Map<String,UserInfo> map=new HashMap<String,UserInfo>();
        UserInfo u1s=new UserInfo();
        u1s.setName("床前明月光");
        u1s.setAge(10);
        map.put("u1s",u1s);
        return map;
    }
    //方法返回值  ---Object list
    @RequestMapping("/five")
    @ResponseBody
    public Object dofive() throws IOException {
        List<UserInfo> list=new ArrayList<UserInfo>();
        UserInfo u1=new UserInfo();
        u1.setName("小花去买菜");
        u1.setAge(10);
        list.add(u1);
        return list;
    }
    //方法返回值  ---对象
    @RequestMapping("/second")
    @ResponseBody
    public Object doSecond() throws IOException {
        UserInfo info=new UserInfo();
        info.setName("happy");
        info.setAge(18);
        return info;
    }
    //方法返回值  ---void ajax
   @RequestMapping("/first")
   public void doFirst(HttpServletResponse response) throws IOException {
       List<UserInfo> list=new ArrayList<UserInfo>();
       UserInfo u1=new UserInfo();
       u1.setName("小花");
       u1.setAge(10);
       list.add(u1);
       //使用json，自动转json.tojsonString
       String json = JSON.toJSONString(list);
       //将json发送到浏览器
       response.getWriter().write(json);
   }

}
