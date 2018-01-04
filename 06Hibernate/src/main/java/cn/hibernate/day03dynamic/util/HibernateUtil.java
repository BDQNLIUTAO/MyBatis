package cn.hibernate.day03dynamic.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2017/12/26.
 */
public class HibernateUtil {
    //线程变量
    static ThreadLocal<Session> tlSession=new ThreadLocal<Session>();
    public static SessionFactory factory;
    static Configuration cfg=null;
    static {
        cfg=new Configuration().configure("hibernate.cfg.xml");
        factory=cfg.buildSessionFactory();
    }
    //1.获取连接
    public static Session getSession(){
        //01 从线程中尝试获取
        Session session=tlSession.get();
        if (session==null){
            session=factory.openSession();
            tlSession.set(session);
        }
        return session;
    }
    //2.释放连接
    public static void closeSession(){
        Session session=tlSession.get();
        if (session!=null){
            tlSession.set(null);
            session.close();
        }
    }
}
