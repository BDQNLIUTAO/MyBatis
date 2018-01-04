package cn.hibernate.day03dynamic.util;

import org.hibernate.Session;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/26.
 */
public class Tool {
    public static Date strDate(String Date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(Date);
    }
}
