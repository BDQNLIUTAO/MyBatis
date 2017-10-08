package cn.happy.spring01;

import cn.happy.spring05xmldi.MyCollection;

import cn.happy.spring06annotationdi.Student;
import cn.happy.spring07staticproxy.ProxySubject;
import cn.happy.spring07staticproxy.RealSubject;
import cn.happy.spring07staticproxy.Subject;
import cn.happy.spring08jdkproxy.IUserDAO;
import cn.happy.spring08jdkproxy.UserDAOImpl;
import cn.happy.spring09cglibproxy.UserService;


import cn.happy.spring12methodinterceptor.SomeService;
import cn.happy.spring13throwsadvise.ISomeService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/9/28.
 */
public class Test20171001 {
    @Test
    //异常增强
    public void Test12(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring08aop04.xml");
        ISomeService service=(ISomeService) context.getBean("proxyService");
        service.doSome();
    }
    @Test
    //环绕增强
    public void Test11(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring07aop03.xml");
        ISomeService service=(ISomeService) context.getBean("proxyService");
        service.doSome();
    }
    @Test
    //后置增强
    public void Test10(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring06aop02.xml");
        SomeService service=(SomeService) context.getBean("proxyService");
        service.doSome();
    }
    @Test
    //前置增强
    public void Test09(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring05aop01.xml");
        SomeService service=(SomeService) context.getBean("proxyService");
        service.doSome();
    }
    //cglib动态代理
    @Test
    public void Test08(){
        final UserService service=new UserService();
        Enhancer enhancer=new Enhancer();
        //在内存中构建业务类的子类
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理对象
             * @param method  代理对象方法
             * @param objects  参数
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                //method.invoke(service,objects);
                methodProxy.invoke(service,objects);
                System.out.println("after");
                return null;
            }
        });
        UserService user=(UserService)enhancer.create();
        user.delete();
    }
    //cglib动态代理
    @Test
    public void Test07(){
        final UserService service=new UserService();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new net.sf.cglib.proxy.InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("事务开启");
                method.invoke(service,objects);
                return null;
            }
        });
       UserService user=(UserService)enhancer.create();
       user.delete();
    }
    //jdk动态代理
    @Test
    public void Test06(){
        final IUserDAO dao=new UserDAOImpl();
        IUserDAO proxy=(IUserDAO)Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("事务已开启。。。");
                method.invoke(dao,args);
                return null;
            }
        });
        proxy.add();
        proxy.edit();
    }
    //静态代理
    @Test
    public void Test05(){
        //真实主题对象
        Subject subject=new RealSubject();
        //代理对象
        ProxySubject proxySubject=new ProxySubject();
        proxySubject.setRealSubject(subject);
        proxySubject.add();
    }
    @Test
    public void Test04(){
        //04.注解的di
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring04annotationdi.xml");
        Student student=(Student) context.getBean("student");
        System.out.println(student);
    }
    @Test
    public void Test03(){
        //03.注解的di
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring04annotationdi.xml");
        Student student=(Student) context.getBean("student");
        student.getData();
    }
    @Test
    public void Test02(){
        //02集合注入测试
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring03xmldi.xml");
        MyCollection collection=(MyCollection) context.getBean("properties");
        System.out.println(collection.getProperties());
    }
    @Test
    public void Test01(){
        //01构造注入测试
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextSpring03xmldi.xml");
        Student stu=(Student) context.getBean("stu");
        System.out.println(stu);
    }
}
