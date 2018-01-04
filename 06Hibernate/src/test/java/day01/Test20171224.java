package day01;

import cn.hibernate.day01.entity.Student;
import cn.hibernate.day01.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/24.
 */
public class Test20171224 {
    @Test
    public void saveOrupdate(){
        Student stu=new Student();
        stu.setSid(14);
        stu.setSname("小虎队");
        stu.setSage(25);
        session.saveOrUpdate(stu);
    }
    @Test
    public void merge(){
        Student stu=new Student();
        stu.setSid(14);
        stu.setSname("小王");
        stu.setSage(25);
        session.merge(stu);
    }
    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        session=factory.openSession();
        //03所有增删改都需在事务环境中执行
        //开启事务
        tx=session.beginTransaction();
    }
    @After
    public void myafter(){
        tx.commit();
        session.close();
    }
}
