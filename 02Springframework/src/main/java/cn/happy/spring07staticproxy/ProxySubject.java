package cn.happy.spring07staticproxy;

/**
 * Created by Administrator on 2017/10/1.
 */
public class ProxySubject implements Subject {
    private Subject realSubject;
    public String add() {
        System.out.println("事务已开启。。。。");
        return realSubject.add();
    }

    public Subject getRealSubject() {
        return realSubject;
    }

    public void setRealSubject(Subject realSubject) {
        this.realSubject = realSubject;
    }
}
