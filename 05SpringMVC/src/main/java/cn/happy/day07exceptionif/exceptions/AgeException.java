package cn.happy.day07exceptionif.exceptions;

import org.omg.CORBA.UserException;

/**
 * Created by Administrator on 2017/11/3.
 */
public class AgeException extends UserException{
    public AgeException() {
    }

    public AgeException(String reason) {
        super(reason);
    }
}
