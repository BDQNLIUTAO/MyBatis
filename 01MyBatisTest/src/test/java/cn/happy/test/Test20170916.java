package cn.happy.test;

import cn.happy.dao.IDeptDao;
import cn.happy.entity.Dept;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public class Test20170916 {
    /*查询用户*/
    @Test
    public void testall() throws IOException {
        String resouce="mybatis-config.xml";
        //1.1 将硬盘上一个xml文件变成一个输入流
        InputStream is= Resources.getResourceAsStream(resouce);
        //1.2 使用流对象作为参数创建一个会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //1.3通过会话工厂创建会话对象  session就是程序员和数据库交互的入口
        SqlSession session=factory.openSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IDeptDao mapper=session.getMapper(IDeptDao.class);
        List<Dept> list=mapper.findall();

        for (Dept dept: list){
            System.out.println(dept.getDeptno()+"\t"+dept.getDeptname());
        }
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*查询用户*/
    @Test
    public void testalllike() throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IDeptDao mapper=session.getMapper(IDeptDao.class);
        Dept dept=new Dept();
        dept.setDeptname("产");
        List<Dept> list=mapper.findlikedept(dept);
        for (Dept depts : list){
            System.out.println(depts.getDeptname());
        }
        //关闭会话，释放资源，提高性能
        session.close();
    }
}
