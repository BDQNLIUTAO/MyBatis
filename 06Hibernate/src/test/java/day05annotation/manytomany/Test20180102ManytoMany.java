package day05annotation.manytomany;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day06annotation.manytomany.StudentManytoMany;
import cn.hibernate.day06annotation.manytomany.TeacherManytoMany;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Administrator on 2018/1/2.
 */
public class Test20180102ManytoMany {
    @Test
    public void t1(){
        Session session = HibernateUtil.getSession();
        Transaction tx=session.beginTransaction();
        TeacherManytoMany teacherManytoMany1=new TeacherManytoMany();
        teacherManytoMany1.setTname("张老师");
        TeacherManytoMany teacherManytoMany2=new TeacherManytoMany();
        teacherManytoMany2.setTname("王老师");
        TeacherManytoMany teacherManytoMany3=new TeacherManytoMany();
        teacherManytoMany3.setTname("陈老师");

        StudentManytoMany studentManytoMany1=new StudentManytoMany();
        studentManytoMany1.setStuname("张三");
        StudentManytoMany studentManytoMany2=new StudentManytoMany();
        studentManytoMany2.setStuname("李四");
        StudentManytoMany studentManytoMany3=new StudentManytoMany();
        studentManytoMany3.setStuname("王五");

        studentManytoMany1.getTeacher().add(teacherManytoMany1);
        studentManytoMany2.getTeacher().add(teacherManytoMany3);

        studentManytoMany2.getTeacher().add(teacherManytoMany1);

        studentManytoMany3.getTeacher().add(teacherManytoMany2);

        session.save(studentManytoMany1);
        session.save(studentManytoMany2);
        session.save(studentManytoMany3);
        tx.commit();
        session.close();
    }
}
