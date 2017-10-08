package cn.happy.test;

import cn.happy.dao.ICategoryDao;
import cn.happy.dao.IDeptDao;
import cn.happy.entity.Category;
import cn.happy.entity.Dept;
import cn.happy.entity.UserInfo;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class Test20170921 {
    @Test
    /*一对多单条sql*/
    public void testfindByid() throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        IDeptDao mapper=session.getMapper(IDeptDao.class);
        Dept dept=mapper.findById(1);
        System.out.println(dept.getDeptname());
        for (UserInfo info:dept.getList()){
            System.out.println(info.getName());
        }
        session.close();
    }
    @Test
    /*一对多单条sql*/
    public void testfind() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        IDeptDao mapper=session.getMapper(IDeptDao.class);
        Dept dept=mapper.findMutliSQL(1);
        System.out.println(dept.getDeptname());
        for (UserInfo info:dept.getList()){
            System.out.println(info.getName());
        }
        session.close();
    }
    @Test
    /*自关联*/
    public void testConnection() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        ICategoryDao mapper=session.getMapper(ICategoryDao.class);
        List<Category> list = mapper.getChildrenListByPid(1);
        for (Category cate:list){
            System.out.println(cate);
        }
        session.close();
    }

}
