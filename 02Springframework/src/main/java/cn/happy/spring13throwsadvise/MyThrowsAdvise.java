package cn.happy.spring13throwsadvise;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by Administrator on 2017/10/3.
 */
public class MyThrowsAdvise implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("报错啦！！！");
    }
}
