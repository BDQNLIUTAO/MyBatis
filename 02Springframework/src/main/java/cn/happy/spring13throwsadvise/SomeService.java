package cn.happy.spring13throwsadvise;

/**
 * Created by Administrator on 2017/10/3.
 */
public class SomeService implements ISomeService {
//    核心内容
    public void doSome(){
        int count=5/0;
        System.out.println("我要找到工作，薪资6，7，8，9，10k。");
    }
}
