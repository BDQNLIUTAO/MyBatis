package cn.smbms.service;

import cn.smbms.entity.UserInfo;
import cn.smbms.util.PageUtil;

import java.util.List;

/**
 * Created by Happy on 2017-11-09.
 */
public interface IUserInfoService {
    //登录
    public UserInfo login(UserInfo info);
    //查询单页用户信息
    public PageUtil<UserInfo> findOnePageData(int pageIndex, int pageSize,String userName);
    //添加用户信息
    public int userAdd(UserInfo user);
    //删除用户信息
    public int userDel(int id);
    //按id查询用户信息
    public UserInfo getinfo(int id);
    //修改用户信息
    public int userUpdate(UserInfo user);
}
