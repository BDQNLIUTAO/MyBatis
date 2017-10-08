package cn.happy.spring07staticproxy;

/**
 * Created by Administrator on 2017/10/1.
 */
public class RealSubject implements Subject {
    public String add() {
        System.out.println("add ok!");
        return "";
    }
}
