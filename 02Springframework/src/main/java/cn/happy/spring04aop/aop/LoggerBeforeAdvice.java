package cn.happy.spring04aop.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/9/30.
 */
public class LoggerBeforeAdvice implements MethodBeforeAdvice {
    /**
     *
     * @param method  目标对象的方法
     * @param objects 方法的参数
     * @param o
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("===========log============");
    }
}
