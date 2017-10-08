package cn.happy.spring01;


import cn.happy.spring02.HappyService;
import cn.happy.spring14advisor01.SomeService;
import cn.happy.spring15aops.service.ISomeService;
import cn.happy.spring16autowire.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Created by Administrator on 2017/9/28.
 */
public class Test20171003 {
    @Test
    //自动注入
    public void Test04(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring10autowire.xml");
        Student stu=(Student) context.getBean("student");
        System.out.println(stu);
    }
    @Test
    //beanfactory创建容器
    public void Test03(){
        Resource resource=new ClassPathResource("applicationContext.xml");
        BeanFactory context=new XmlBeanFactory(resource);
        context.getBean("service");
    }
    @Test
    //名称匹配方法切入点顾问
    public void Test02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring09aops.xml");
        ISomeService service=(ISomeService) context.getBean("someService");
        service.doSome();
    }
   /* @Test
    //名称匹配方法切入点顾问
    public void Test01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring05advisor01.xml");
        ISomeService service=(ISomeService) context.getBean("proxyService");
        service.doSome();
        service.add();
    }*/

}
