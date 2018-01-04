package day01;

import cn.hibernate.day01.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/21.
 */
public class Test20171221 {
    /**
     * 删除学生
     */
    @Test
    public void delStu(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        //03所有增删改都需在事务环境中执行
        //开启事务
        Transaction tx=session.beginTransaction();
        Student stu=new Student();
        stu.setSid(72);
        session.delete(stu);
        tx.commit();
        session.close();
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
   /*
     * 修改学生方式一
     */
    @Test
    public void updateStuDemo1(){
        Student student = session.get(Student.class, 5);
        student.setSname("大老板666");
    }

    /**
     * 修改学生方式二 update()
     */
    @Test
    public void updateStuDemo2(){
        Student stu=new Student();
        stu.setSid(2);
        stu.setSname("孙丽琴");
        session.update(stu);
    }
    @Test
    public void updateStuDemo3(){
        Student stu=new Student();
        stu.setSid(2);
        stu.setSname("孙丽琴好人");
        session.merge(stu);
    }
    @After
    public void myafter(){
        tx.commit();
        session.close();
    }
    /**
    *
     * 添加学生
     */
    @Test
    public void addStu(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        //03所有增删改都需在事务环境中执行
        //开启事务
        Transaction tx=session.beginTransaction();
        Student stu=new Student();
        stu.setSname("张天赐");
        stu.setSage(58);
        //添加
        session.save(stu);
        //事务提交
        tx.commit();
        session.close();
    }
    /**
     * 查询编号为5的学生 load()
     */
    @Test
    public void demo2(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Student student=session.load(Student.class,5);
        System.out.println(student.getSname());
    }
    /**
     * 查询编号为3的学生 get()
     */
    @Test
    public void demo1(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.getCurrentSession();
        Transaction tx=session.beginTransaction();
        Student student=session.get(Student.class,"4028817e608698a301608698a5990000");
        tx.commit();
        System.out.println(student.getSname());
    }
}
