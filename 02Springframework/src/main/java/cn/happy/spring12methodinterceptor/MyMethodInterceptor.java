package cn.happy.spring12methodinterceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2017/10/3.
 */
public class MyMethodInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("brfore");
        methodInvocation.proceed();
        System.out.println("after");
        return null;
    }
}
