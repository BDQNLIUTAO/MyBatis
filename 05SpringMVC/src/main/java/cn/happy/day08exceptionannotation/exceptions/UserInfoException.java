package cn.happy.day08exceptionannotation.exceptions;

/**
 * Created by Administrator on 2017/11/3.
 * 用户信息异常
 * 自定义异常 Exception：编译时异常
 * RumTimeException：运行时异常
 */
public class UserInfoException extends Exception {
    public UserInfoException() {
        super();
    }

    public UserInfoException(String message) {
        super(message);
    }
}
