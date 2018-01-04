package day04opensessioninview;

import cn.hibernate.day04mapping.manytomany.Employee;
import cn.hibernate.day05opensessioninview.service.EmployeeService;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/31.
 */
public class Test20171231 {
    @Test
    public void testNoSession(){
        EmployeeService service=new EmployeeService();
        Employee employee = (Employee)service.getData(Employee.class, 44);
        System.out.println(employee.getEmpname());
    }
}
