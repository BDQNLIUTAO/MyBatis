package day06connect;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day06annotation.onetomany.Dept;
import cn.hibernate.day06annotation.onetomany.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */
public class Test20180104 {
    //迫切内连接内连接  查询部门和员工
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Emp e inner join e.dept");
        List<Object[]> list=query.list();
        for (Object[] item:list
                ) {
            System.out.println(item[0]);
            System.out.println(item[1]);
        }
    }
    //迫切内连接内连接  查询部门和员工
    @Test
    public void t2(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Emp e inner join fetch e.dept");
        List<Emp> list=query.list();
        for (Emp item:list
             ) {
            System.out.println(item.getEname());
            System.out.println(item.getDept().getDname());
        }
    }
    //隐式内连接
    @Test
    public void t3(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Emp e where e.dept.dname='开发部'");
        List<Emp> list=query.list();
        for (Emp item:list
                ) {
            System.out.println(item.getEname());
        }
    }
    //子查询
    @Test
    public void t4(){
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from Dept d where 5000>all(select e.empno from d.emps e)");
        List<Dept> list=query.list();
        for (Dept dept:list
             ) {
            System.out.println(dept.getDname());
        }
    }

}
