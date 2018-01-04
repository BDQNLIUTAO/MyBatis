package day05annotation.base;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day06annotation.base.Dept;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2018/1/2.
 */
public class Test20180102 {
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Dept dept=new Dept();
        dept.setDname("开发部");
        session.save(dept);
        tx.commit();
        session.close();
    }
}
