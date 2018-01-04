package cn.hibernate.day05opensessioninview.dao;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/31.
 */
public class EmployeeDAO {
    //通过load方法获取一个员工
    public Object getData(Class clazz, Serializable id){
        Session session = HibernateUtil.getSession();
        Object obj = session.load(clazz, id);
        return obj;
    }
}
