package cn.happy.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/9/16.
 */
public class MyBatisUtil {
    private static String path="mybatis-config.xml";
    private static SqlSessionFactory factory;
    //对外Sqlsession
    //静态方法
    public static SqlSession getSession() throws IOException {
        InputStream in= org.apache.ibatis.io.Resources.getResourceAsStream(path);
        factory=new SqlSessionFactoryBuilder().build(in);
        return factory.openSession();
    }
}