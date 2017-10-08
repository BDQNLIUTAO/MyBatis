package cn.happy.spring10aop01;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/10/3.
 */
//前置通知
public class MyBeforeAdvise implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("================log================");
    }
}
