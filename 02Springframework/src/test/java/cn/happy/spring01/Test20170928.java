package cn.happy.spring01;

import cn.happy.spring01.printer.Print;
import cn.happy.spring02.HappyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/9/28.
 */
public class Test20170928 {
    @Test
    public void Test01(){
        //拿到Spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyService service=(HappyService)context.getBean("service");
        System.out.println(service);
    }
    @Test
    public void Test02(){
        //拿到Spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Print print=(Print)context.getBean("printer");
        print.printSomething();
    }
}
