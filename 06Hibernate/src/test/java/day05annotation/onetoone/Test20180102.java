package day05annotation.onetoone;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day06annotation.onetoone.Dept;
import cn.hibernate.day06annotation.onetoone.Emp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2018/1/2.
 */
public class Test20180102 {
    //注解开发  一对一关联关系
    @Test
    public void test1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDname("运营部");
        Emp emp=new Emp();
        emp.setEname("呵呵");
        dept.setEmp(emp);
        emp.setDept(dept);
        session.save(dept);
        tx.commit();
        session.close();
    }

}
