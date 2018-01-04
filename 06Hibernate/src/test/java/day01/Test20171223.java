package day01;

import cn.hibernate.day01.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/23.
 */
public class Test20171223 {
    /**
     * 生成sql语句到数据库
     */
    @Test
    public void test1(){
        ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder().configure("hibernate.cfgmysql.xml").build();
        MetadataImplementor metadataImplementor = (MetadataImplementor) new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport export = new SchemaExport(serviceRegistry, metadataImplementor);
        export.create(true, true);
    }
    Session session;
    Transaction tx;
    @Before
    public void mybefore(){
        //01构建Configuration对象  读取大配置
        Configuration cfg=new Configuration().configure();
        //02构建工厂
        SessionFactory factory=cfg.buildSessionFactory();
        session=factory.openSession();
        //03所有增删改都需在事务环境中执行
        //开启事务
        tx=session.beginTransaction();
    }
    /*
      * 删除用户
      */
    @Test
    public void userDel(){
        Users users=new Users();
        users.setId(10);
        session.delete(users);
    }
    /*
      * 添加用户
      */
    @Test
    public void userAdd(){
        Users users=new Users();
        users.setName("水浒传");
        users.setPassword("123456");
        users.setTelephone("15931787948");
        users.setUsername("曹梅花");
        users.setIsadmin("1");
        //添加
        session.save(users);
    }
    /*
      * 修改用户
      */
    @Test
    public void userUpdate(){
        Users user=session.get(Users.class,11);
        user.setName("大老板666");
    }
    /*
     * 查询用户
     */
    @Test
    public void userSelect(){
        Users user=session.get(Users.class,11);
        System.out.println(user.getName());
    }
    @After
    public void myafter(){
        tx.commit();
        session.close();
    }
}
