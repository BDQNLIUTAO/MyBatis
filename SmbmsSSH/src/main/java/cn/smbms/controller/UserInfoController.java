package cn.smbms.controller;

import cn.smbms.entity.UserInfo;
import cn.smbms.service.IUserInfoService;
import cn.smbms.util.PageUtil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
@Controller
public class UserInfoController {
    //service
    @Resource(name = "userService")
    IUserInfoService userInfoService;

    //登录
   @RequestMapping("/login")
  public String isLogin(UserInfo info, HttpSession session){
       UserInfo user = userInfoService.login(info);
       if(user!=null){
           //登录成功
           session.setAttribute("userinfo",user);
           return "/pages/welcome.jsp";
       }else{
        //登录失败，跳回login
           return "/pages/login.jsp";
       }
   }
   //pagination
    @RequestMapping("/finUser1")
    @ResponseBody
    public Object findalluser1(Model model,@RequestParam(defaultValue = "1",required = false)int pageIndex, @RequestParam(defaultValue = "2",required = false) int pageSize,String userName){
        PageUtil<UserInfo> page = userInfoService.findOnePageData(pageIndex, pageSize,userName);
        return page;
    }
   //EasyUI
    @RequestMapping("/finUser")
    @ResponseBody
    public Object findalluser(Model model,@RequestParam(defaultValue = "1",required = false,value = "page")int pageIndex, @RequestParam(defaultValue = "2",required = false,value = "rows") int pageSize,String userName){
        Map<String,Object> map=new HashMap<String,Object>();
        PageUtil<UserInfo> page = userInfoService.findOnePageData(pageIndex, pageSize,userName);
        map.put("total",page.getTotalRecords());
        map.put("rows",page.getList());
        return map;
    }
    //时间类型的转换
     @InitBinder
     public void initbinder(WebDataBinder binder){
         DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
     }
    @InitBinder
     public void initbinder2(WebDataBinder binder){
        DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
    }
     //添加用户信息
    @RequestMapping("userAdd")
    public String userAdd(UserInfo user) {
        int count = userInfoService.userAdd(user);
        if(count>1){
            return "/pages/userList.jsp";
        }else {
            return "/pages/userAdd.jsp";
        }
    }
    //删除用户信息
    @RequestMapping("userDel")
    @ResponseBody
    public Object userDel(String id){
        String[] split = id.split(",");// 拆解逗号
        int count=0;
        for (int i=0;i<split.length;i++){
            count = userInfoService.userDel(Integer.parseInt(split[i])); //在遍历数组时删除批量数据
        }
        boolean flag=false;
        if (count>0)
            flag=true;
        return flag;
       /* int count = userInfoService.userDel(id);
        return "/pages/userList.jsp";*/
    }
    //修改用户信息
    @RequestMapping("userUpdate")
    public String userUpdate(UserInfo user){
        int count = userInfoService.userUpdate(user);
        return "/pages/userList.jsp";
    }
    //按id查询用户信息
    @RequestMapping("getinfo")
    public String getinfo(int id,HttpSession session){
        UserInfo info = userInfoService.getinfo(id);
        session.setAttribute("info",info);
        return "/pages/userUpdate.jsp";
    }
}
