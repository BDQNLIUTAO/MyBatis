package day03mapping.manytoone;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day04mapping.manytomany.Employee;
import cn.hibernate.day04mapping.manytomany.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/28.
 */
public class Test20171228_2 {
    @Test
    public void t4(){
        Session session = HibernateUtil.getSession();
        Employee load = session.load(Employee.class, 42);
        System.out.println(load.getEmpname());
    }
    //多对多双向  查询指定工程参与人员
    //查询员工所属工程
    @Test
    public void t3(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Project project = session.load(Project.class, 52);
        System.out.println(project.getProname());
        for (Employee item:project.getEmployees()
             ) {
            System.out.println(item.getEmpname());
        }
        tx.commit();
        session.close();
    }
    //多对多 单向关联  添加一个员工对应多个工程
    @Test
    public void t2(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Employee emp1=new Employee();
        emp1.setEmpname("曹梅花2");
        Project pro1=new Project();
        pro1.setProname("海淀花园2");
        Project pro2=new Project();
        pro2.setProname("三国统治2");

        emp1.getProjects().add(pro1);
        emp1.getProjects().add(pro2);

        session.save(emp1);
        session.save(pro1);
        session.save(pro2);
        tx.commit();
        session.close();
    }
    //查询员工所属工程
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        Employee employee = session.load(Employee.class, 41);
        System.out.println(employee.getEmpname());
        System.out.println("===========================");;
        for (Project item:employee.getProjects()
             ) {
            System.out.println(item.getProname());
        }
        tx.commit();
        session.close();
    }
}
