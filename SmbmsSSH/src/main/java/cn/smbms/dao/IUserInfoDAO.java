package cn.smbms.dao;

import cn.smbms.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Happy on 2017-11-09.
 */
public interface IUserInfoDAO {
    //登录
    public UserInfo login(UserInfo info);
    //查询单页用户信息
    public List<UserInfo> findOnePageData(Map<String,Object> map);
    //查询总记录数
    public int getTotalRecords(Map<String,Object> map);
    //添加用户信息
    public int userAdd(UserInfo user);
    //删除用户信息
    public int userDel(int id);
    //按id查询用户信息
    public UserInfo getinfo(int id);
    //修改用户信息
    public int userUpdate(UserInfo user);
}
