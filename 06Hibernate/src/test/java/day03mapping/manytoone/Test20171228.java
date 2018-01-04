package day03mapping.manytoone;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day04mapping.onetomanydouble.Dept;
import cn.hibernate.day04mapping.onetomanydouble.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
public class Test20171228 {
    //关联查询 多对一单项关联
    @Test
    public void t1(){
        //工具类
        Session session = HibernateUtil.getSession();
        //提供一个员工编号
        Emp emp = session.load(Emp.class, 20);
        System.out.println(emp);
       System.out.println(emp.getEname());
        //员工所属部门
       System.out.println(emp.getDept().getDname());
    }

   //保存部门和员工
    @Test
    public void t2(){
        //工具类
        Session session = HibernateUtil.getSession();
        //开启事务
        Transaction tx=session.beginTransaction();
        //实例化dept
        Dept dept=new Dept();
        dept.setDname("后勤部666");
        Emp emp=new Emp();
        emp.setEname("孙俪");
        //设置员工所属的部门
        emp.setDept(dept);
        session.save(dept);
        session.save(emp);
        tx.commit();
        session.close();
    }
    //按照指定的部门对象查询相关的员工对象
    @Test
    public void t3(){
        Session session = HibernateUtil.getSession();
        String hql="from Emp e where e.dept.deptno=15";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        for (Emp emps:list
                ) {
            System.out.println("所属员工:"+emps.getEname());
        }
    }
    //输出指定emps集合中所有emp对象及所关联的部门对象信息
    @Test
    public void t4(){
        Session session = HibernateUtil.getSession();
        String hql="from Emp";
        Query query = session.createQuery(hql);
        List<Emp> list = query.list();
        for (Emp emps:list
                ) {
            System.out.println("部门名称："+emps.getDept().getDname());
            System.out.println("所属员工为："+emps.getEname());
        }
    }
    //；修改编号为1的员工所属部门
    @Test
    public void t5(){
        //工具类
        Session session = HibernateUtil.getSession();
        //开启事务
        Transaction tx=session.beginTransaction();
        Emp emp = session.load(Emp.class, 18);
        Dept dept=new Dept();
        dept.setDeptno(15);
        emp.setDept(dept);
        dept.getEmps().add(emp);
        tx.commit();

        session.close();
    }
    @Test
    public void t6(){
        //通过部门查询该部分下所有员工信息（设置从部门到员工的一级关联）
        String hql="from Dept";
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery(hql);
        List<Dept> list = query.list();
        for (Dept item:list
             ) {
            System.out.println("========================");
            System.out.println(item.getDname());
            for (Emp emps:item.getEmps()
                 ) {
                System.out.println(emps.getEname());
            }
            System.out.println("===========END==============");
        }
        //通过某个员工获取员所在部门（设置从员工到部门的多对一关联）
        Emp emps = session.load(Emp.class, 18);
        System.out.println(emps.getDept().getDname());
    }
    //添加部门同时添加员工
    @Test
    public void t7(){
       Session session = HibernateUtil.getSession();
      Transaction tran = session.beginTransaction();
      //准备一个emp对象
       Dept dept=new Dept();
      dept.setDname("餐饮部4");
      //准备一个emp对象
      Emp emp=new Emp();
      emp.setEname("张三4");
      dept.getEmps().add(emp);
      session.save(dept);
     // 事务提交
     tran.commit();
   }
   @Test
    public void t8(){
       Session session = HibernateUtil.getSession();
       List<Dept> list = session.createQuery("from Dept").list();
       for (Dept dept : list) {
           for (Emp emp : dept.getEmps()) {
               System.out.println(emp.getEmpno()+"\t"+emp.getEname());
           }
       }
   }
}
