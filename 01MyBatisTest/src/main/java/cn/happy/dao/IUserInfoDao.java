package cn.happy.dao;

import cn.happy.entity.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public interface IUserInfoDao {
    /*查询全部用户*/
    public List<UserInfo> findall();
    /*按指定编号检索用户  返回的ResultMap*/
    public UserInfo getUserResultMapById(int id);
    /*增加用户*/
    public int adduser(UserInfo userInfo);
    /*修改用户*/
    public int edituser(UserInfo userInfo);
    /*删除用户*/
    public int deluser(int id);
    /*按多条件查询索引号方案*/
    public List<UserInfo> findUserInfoByManyConditionByIndex(String name, int age);
    /*智能标签if*/
    public List<UserInfo> findByif(UserInfo user);
    /*智能标签choose*/
    public List<UserInfo> findBychoose(UserInfo user);
    /*智能标签*/
    public List<UserInfo> findByForeachArray(int[] ids);
}
