package cn.happy.day07exceptionif.exceptions;

import org.omg.CORBA.UserException;

/**
 * Created by Administrator on 2017/11/3.
 */
public class NameException extends UserException {
    public NameException() {
    }

    public NameException(String reason) {
        super(reason);
    }
}
