package cn.happy.spring04aop.dao;

import cn.happy.spring04aop.entity.User;

/**
 * Created by Administrator on 2017/9/30.
 */
public class UserDAOImpl implements IUserDAO {
    public void save(User user) {
        System.out.println("save success");
    }
}
