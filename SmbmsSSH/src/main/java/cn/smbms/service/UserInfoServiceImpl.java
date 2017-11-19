package cn.smbms.service;

import cn.smbms.dao.IUserInfoDAO;
import cn.smbms.entity.UserInfo;
import cn.smbms.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {
    //植入DAO层
    @Resource(name = "IUserInfoDAO")
    private IUserInfoDAO userInfoDAO;

    //登录
    public UserInfo login(UserInfo info) {
        return userInfoDAO.login(info);
    }

    //分页查询
    public PageUtil<UserInfo> findOnePageData(int pageIndex,int pageSize,String userName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageIndex", (pageIndex-1) * pageSize);
        map.put("pageSize", pageSize);
        map.put("userName",userName);
        PageUtil<UserInfo> page=new PageUtil<UserInfo>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        int totalRecords=userInfoDAO.getTotalRecords(map);
        page.setTotalRecords(totalRecords);
        //总页数=totalRecords/pageSize
        page.setTotalPages(page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1);
        page.setList(userInfoDAO.findOnePageData(map));
        return page;
    }

    //添加用户信息
    public int userAdd(UserInfo user) {
        return userInfoDAO.userAdd(user);
    }

    //删除用户信息
    public int userDel(int id) {
        return userInfoDAO.userDel(id);
    }

    //按id查询用户信息
    public UserInfo getinfo(int id) {
        return userInfoDAO.getinfo(id);
    }

    //修改用户信息
    public int userUpdate(UserInfo user) {
        return userInfoDAO.userUpdate(user);
    }
}
