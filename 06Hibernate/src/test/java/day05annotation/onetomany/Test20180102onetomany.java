package day05annotation.onetomany;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day06annotation.onetomany.Dept;
import cn.hibernate.day06annotation.onetomany.Emp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2018/1/2.
 */
public class Test20180102onetomany {
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Emp emp1=new Emp();
        emp1.setEname("张三");
        Emp emp2=new Emp();
        emp2.setEname("王五");

        Dept dept=new Dept();
        dept.setDname("开发部");

        emp2.setDept(dept);
        emp1.setDept(dept);
        session.save(emp1);
        session.save(emp2);
        tx.commit();
        session.close();
    }
}
