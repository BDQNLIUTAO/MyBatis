package cn.happy.spring04aop.service;

import cn.happy.spring04aop.dao.IUserDAO;
import cn.happy.spring04aop.entity.User;

/**
 * Created by Administrator on 2017/9/30.
 */
public class UserServiceImpl implements IUserService {
    private IUserDAO dao;
    public void save2(User user) {
        dao.save(user);
    }

    public IUserDAO getDao() {
        return dao;
    }

    public void setDao(IUserDAO dao) {
        this.dao = dao;
    }
}