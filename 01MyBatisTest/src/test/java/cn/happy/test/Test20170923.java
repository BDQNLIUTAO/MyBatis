package cn.happy.test;

import cn.happy.dao.IDeptDao;
import cn.happy.dao.ITeacherDao;
import cn.happy.entity.Dept;
import cn.happy.entity.Student;
import cn.happy.entity.Teacher;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class Test20170923 {
    @Test
    public void testlevel(){
        String path = System.getProperty("java.io.tmpdir");
        System.out.println(path);
    }
    /*二级缓存存在证明*/
    @Test
    public void testtwoLevel() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        List<Dept> list = mapper.findall();
        System.out.println(list);
        session.close();
        System.out.println("=================================");
        SqlSession session2=MyBatisUtil.getSession();
        IDeptDao mapper2 = session2.getMapper(IDeptDao.class);
        List<Dept> list2 = mapper2.findall();
        System.out.println(list2);
        session.close();
    }
    @Test
    /*一级缓存存在的证明*/
    public void testoneLevel() throws IOException {
       SqlSession session=MyBatisUtil.getSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        List<Dept> list = mapper.findall();
        System.out.println(list);
        System.out.println("=========================================");
        List<Dept> list2 = mapper.findall();
        System.out.println(list2);
    }
    @Test
    /*延迟加载测试*/
    public void testlazy() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        IDeptDao mapper=session.getMapper(IDeptDao.class);
        Dept dept=mapper.findMutliSQL(1);
        System.out.println(dept.getDeptname());
        session.close();
    }
    @Test
    /*多对多*/
    public void testfindByid() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        ITeacherDao mapper=session.getMapper(ITeacherDao.class);
        Teacher teacher=mapper.getTeacherById(1);
        System.out.println(teacher.getTname());

        for (Student stu:teacher.getStus()){
            System.out.println(stu.getSname());
        }
        session.close();
    }

}
