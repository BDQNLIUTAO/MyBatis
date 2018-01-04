package day02;

import cn.hibernate.day02.entity.Dept;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */
public class Test20171224 {
    /**
     * 获取部分列 多列 Object[]
     */
    @Test
    public void testgetMultipelColumns(){
        String hql="select d.dname,d.loc from Dept d";
        Query query=session.createQuery(hql);
        List<Object[]> list=query.list();
        for (Object[] item:list){
            for (Object items:item) {
                System.out.println(items+"--");
            }
            System.out.println();
        }
    }
    /**
     * 获取部分列
     */
    @Test
    public void testgetMultiColumns(){
        String hql="select d.dname from Dept d";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
    /**
     * 获取销售部信息
     */
    @Test
    public void testselectSomeRows(){
        String hql="from Dept d where d.dname='SALES'";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
    /**
     * 检索所有部门集合
     */
    @Test
    public void testselectAllDepts(){
        String hql="from cn.hibernate.day02.entity.Dept";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
    @Test
    public void testselectAllDeptss(){
        String hql="from Dept";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept item:list){
            System.out.println(item.getDname());
        }
    }
    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure("hibernate.cfgscott.xml");
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
