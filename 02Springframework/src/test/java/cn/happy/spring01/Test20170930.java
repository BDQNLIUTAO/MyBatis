package cn.happy.spring01;

import cn.happy.spring03areaproperty.Student;
import cn.happy.spring04aop.entity.User;
import cn.happy.spring04aop.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/9/28.
 */
public class Test20170930 {
    @Test
    public void Test02(){
        //02aop测试
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring02aop.xml");
        IUserService service=(IUserService) context.getBean("service");
        User user=new User();
        service.save2(user);
    }
    @Test
    public void Test01(){
        //01域属性测试
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring02areaproperty.xml");
        Student stu=(Student) context.getBean("stu");
        System.out.println(stu);
    }
}
