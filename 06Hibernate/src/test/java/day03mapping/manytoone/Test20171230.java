package day03mapping.manytoone;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day04mapping.manytomanydoublebyonetomany.Employee;
import cn.hibernate.day04mapping.manytomanydoublebyonetomany.ProEmp;
import cn.hibernate.day04mapping.manytomanydoublebyonetomany.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/28.
 */
public class Test20171230 {

    //多对多双向关联  拆分成两个多对一  添加
    @Test
    public void t4(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        //创建EMP对象
        Employee emp=new Employee();
        emp.setEmpname("李小龙");

        //创建Pro对象
        Project pro=new Project();
        pro.setProname("海淀花园");

        //创建ProEmp对象
        ProEmp proemp=new ProEmp();
        proemp.setEmp(emp);
        proemp.setPro(pro);

        session.save(emp);
        session.save(pro);
        session.save(proemp);
        // 事务提交
        tx.commit();
        session.close();
        System.out.println("成功");
    }

}
