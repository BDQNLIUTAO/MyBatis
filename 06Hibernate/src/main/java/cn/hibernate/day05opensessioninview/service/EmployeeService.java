package cn.hibernate.day05opensessioninview.service;

import cn.hibernate.day03dynamic.util.HibernateUtil;
import cn.hibernate.day04mapping.manytomany.Employee;
import cn.hibernate.day05opensessioninview.dao.EmployeeDAO;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/31.
 */
public class EmployeeService {
    EmployeeDAO dao=new EmployeeDAO();
    public Object getData(Class clazz, Serializable id){
        Object data = dao.getData(clazz, id);
      /*  if (!Hibernate.isInitialized(data)){
            Hibernate.isInitialized(data);
        }*/
/*        Employee employee=(Employee)data;
        employee.getEmpname();*/
        return data;
    }
}
