package day02;

import cn.hibernate.day02.entity.Dept;
import cn.hibernate.day02.entity.viewmodel.DeptModel;
import cn.hibernate.day03dynamic.entity.Emp;
import cn.hibernate.day03dynamic.entity.viewmodel.EmpCondition;
import cn.hibernate.day03dynamic.util.Tool;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */
public class Test20171226 {
    /**
     * 分页
     */
    @Test
    public void selectPage(){
        String hql="from Emp order by empno";
        Query query = session.createQuery(hql);
        int pageIndex=1;
        int pageSize=3;
        query.setFirstResult((pageIndex-1)*pageSize);
        query.setMaxResults(pageSize);
        List<Emp> empList=query.list();
        for (Emp emp:empList){
            System.out.println(emp.getEname());
        }
    }
    /**
     * 动态sql
     */
    @Test
    public void selectByDynamic() throws ParseException {
        EmpCondition emp=new EmpCondition();
        emp.setJob("CLERK");
        emp.setSal(1000.0);
        //入职时间
        emp.setFromDate(Tool.strDate("1891-05-01"));
        //离职时间
        emp.setEndDate(new Date());
        //根据条件拼接sql
        StringBuilder sb=new StringBuilder("from Emp e where 1=1");
        if(emp.getJob()!=null){
            sb.append("and e.job =:job ");
        }
        if(emp.getSal()!=null){
            sb.append("and e.sal >:sal ");
        }
        if (emp.getFromDate()!=null){
            sb.append("and e.hiredate >=:fromDate ");
        }
        if (emp.getEndDate()!=null){
            sb.append("and e.hiredate <=:endDate ");
        }
        Query query=session.createQuery(sb.toString());
        query.setProperties(emp);
        List<Emp> list = query.list();
        for (Emp item:list) {
            System.out.println(item.getEname());
        }
    }
    /**
     * 参数查询：  方案三：:dname  参数名称绑定+对象属性
     */
    @Test
    public void selectByConditionParameternameAndObjectAttribute(){
        //部门名称为SALES的部门信息
        String hql="from Dept d where d.dname=:dname and d.loc=:loc";
        Query query = session.createQuery(hql);
        DeptModel model=new DeptModel();
        model.setDname("SALES");
        model.setLoc("CHICAGO");
        query.setProperties(model);
        List<Dept> list = query.list();
        for (Dept dept:list) {
            System.out.println(dept.getDname());
        }
    }
    /**
     * 参数查询：  方案二：:dname  参数名称绑定
     */
    @Test
    public void selectByConditionParametername(){
        //部门名称为SALES的部门信息
        String hql="from Dept d where d.dname=:dname and d.loc=:loc";
        Query query = session.createQuery(hql);
        query.setParameter("dname","SALES");
        query.setParameter("loc","CHICAGO");
        List<Dept> list = query.list();
        for (Dept dept:list) {
            System.out.println(dept.getDname());
        }
    }
    /**
     * 参数查询：  方案一：？ 匿名占位符
     */
    @Test
    public void selectByConditionNiming(){
        //部门名称为SALES的部门信息
        String hql="from Dept d where d.dname=? and d.loc=?";
        Query query = session.createQuery(hql);
        query.setParameter(0,"SALES");
        query.setParameter(1,"CHICAGO");
        List<Dept> list = query.list();
        for (Dept dept:list
             ) {
            System.out.println(dept.getDname());
        }
    }
    /**
     * 获取部分列 多列  list<强类型>
     */
    @Test
    public void testgetMultipelColumns(){
        String hql="select new Dept(d.deptno,d.dname,d.loc) from Dept d";
        Query query=session.createQuery(hql);
        List<Dept> list=query.list();
        for (Dept dept:list){
            System.out.println(dept.getDname());
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
