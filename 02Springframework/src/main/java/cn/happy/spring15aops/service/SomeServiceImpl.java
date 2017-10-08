package cn.happy.spring15aops.service;

import cn.happy.spring15aops.dao.ISomeDAO;

/**
 * Created by Administrator on 2017/10/7.
 */
public class SomeServiceImpl implements ISomeService {
    private ISomeDAO dao;
    public void doSome() {
        dao.doSome();
    }

    public ISomeDAO getDao() {
        return dao;
    }

    public void setDao(ISomeDAO dao) {
        this.dao = dao;
    }
}
